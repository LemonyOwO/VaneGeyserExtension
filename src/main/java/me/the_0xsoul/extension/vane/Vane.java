package me.the_0xsoul.extension.vane;

import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.event.lifecycle.GeyserDefineCustomItemsEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserDefineResourcePacksEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserPostInitializeEvent;
import org.geysermc.geyser.api.extension.Extension;
import org.geysermc.geyser.api.item.custom.CustomItemData;
import org.geysermc.geyser.api.item.custom.CustomItemOptions;
import org.geysermc.geyser.api.util.CreativeCategory;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

public class Vane implements Extension {

    private final AtomicBoolean registered = new AtomicBoolean(false);
    private BiConsumer<String, CustomItemData> registrar;

    /**
     * Geyser 2.8 path
     */
    @Subscribe
    public void onDefineCustomItems(GeyserDefineCustomItemsEvent event) {
        registrar = event::register;
        tryRegister();
    }

    /**
     * Geyser 2.9 safe path (reflection-based)
     */
    @Subscribe
    public void onPostInitialize(GeyserPostInitializeEvent event) {
        if (registrar == null) {
            registrar = create2_9Registrar();
        }
        tryRegister();
    }

    private void tryRegister() {
        if (!registered.compareAndSet(false, true)) {
            return;
        }

        logger().info("");
        logger().info("##############################################");
        logger().info("Vane Geyser Extension");
        logger().info("Made by: 0xSoul, updated to Geyser 2.9+ by LemonyOwO");
        logger().info("##############################################");
        logger().info("");

        registerCustomItems();

        logger().info("Vane custom items registered (2.8 + 2.9 compatible)");
    }

    /**
     * Reflection bridge for Geyser 2.9+
     */
    private BiConsumer<String, CustomItemData> create2_9Registrar() {
        try {
            Object geyserApi = geyserApi();

            Method getRegistry = geyserApi.getClass()
                    .getMethod("getCustomItemRegistry");

            Object registry = getRegistry.invoke(geyserApi);

            Method register = registry.getClass()
                    .getMethod("register", String.class, CustomItemData.class);

            return (vanilla, item) -> {
                try {
                    register.invoke(registry, vanilla, item);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to register custom item", e);
                }
            };
        } catch (Exception e) {
            throw new RuntimeException(
                    "Geyser 2.9 detected but CustomItemRegistry API not found", e);
        }
    }

    private void registerCustomItems() {

        //
        // BOOK
        //
        register("minecraft:book", "ancient_tome", 7798784, CreativeCategory.ITEMS);
        register("minecraft:book", "ancient_tome_of_knowledge", 7798786, CreativeCategory.ITEMS);
        register("minecraft:book", "anc
