package me.the_0xsoul.extension.vane;

import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.event.lifecycle.GeyserDefineCustomItemsEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserDefineResourcePacksEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserPostInitializeEvent;
import org.geysermc.geyser.api.extension.Extension;
import org.geysermc.geyser.api.item.custom.CustomItemData;
import org.geysermc.geyser.api.item.custom.CustomItemOptions;
import org.geysermc.geyser.api.util.CreativeCategory;

import java.util.concurrent.atomic.AtomicBoolean;

public class Vane implements Extension {

    /** Ensures we only register once */
    private final AtomicBoolean registered = new AtomicBoolean(false);

    /**
     * Geyser 2.8 path (safe there, unsafe on 2.9 Velocity)
     */
    @Subscribe
    public void onDefineCustomItems(GeyserDefineCustomItemsEvent event) {
        tryRegister();
    }

    /**
     * Geyser 2.9 safe path
     */
    @Subscribe
    public void onPostInitialize(GeyserPostInitializeEvent event) {
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

    private void registerCustomItems() {

        //
        // BOOK
        //
        register("minecraft:book", "ancient_tome", 7798784, CreativeCategory.ITEMS);
        register("minecraft:book", "ancient_tome_of_knowledge", 7798786, CreativeCategory.ITEMS);
        register("minecraft:book", "ancient_tome_of_the_gods", 7798788, CreativeCategory.ITEMS);

        //
        // COMPASS
        //
        register("minecraft:compass", "north_compass", 7733267, CreativeCategory.EQUIPMENT);

        //
        // DIAMOND HOE
        //
        register("minecraft:diamond_hoe", "diamond_sickle", 7733256, CreativeCategory.EQUIPMENT);

        //
        // DROPPER
        //
        register("minecraft:dropper", "pouch", 7733270, CreativeCategory.ITEMS);

        //
        // ELYTRA
        //
        register("minecraft:elytra", "reinforced_elytra", 7733250, CreativeCategory.EQUIPMENT);

        //
        // ENCHANTED BOOK
        //
        register("minecraft:enchanted_book", "enchanted_ancient_tome", 7798785, CreativeCategory.ITEMS);
        register("minecraft:enchanted_book", "enchanted_ancient_tome_of_knowledge", 7798787, CreativeCategory.ITEMS);
        register("minecraft:enchanted_book", "enchanted_ancient_tome_of_the_gods", 7798789, CreativeCategory.ITEMS);

        //
        // GLASS BOTTLE
        //
        register("minecraft:glass_bottle", "empty_xp_bottle", 7733258, CreativeCategory.EQUIPMENT);
        register("minecraft:glass_bottle", "small_xp_bottle", 7733259, CreativeCategory.ITEMS);
        register("minecraft:glass_bottle", "medium_xp_bottle", 7733260, CreativeCategory.EQUIPMENT);
        register("minecraft:glass_bottle", "large_xp_bottle", 7733261, CreativeCategory.EQUIPMENT);

        //
        // GOLDEN HOE
        //
        register("minecraft:golden_hoe", "golden_sickle", 7733255, CreativeCategory.EQUIPMENT);

        //
        // IRON HOE
        //
        register("minecraft:iron_hoe", "iron_sickle", 7733254, CreativeCategory.EQUIPMENT);

        //
        // NETHERITE HOE
        //
        register("minecraft:netherite_hoe", "netherite_sickle", 7733257, CreativeCategory.EQUIPMENT);

        //
        // PAPER
        //
        register("minecraft:paper", "papyrus_scroll", 7733263, CreativeCategory.ITEMS);

        //
        // SHULKER BOX
        //
        register("minecraft:shulker_box", "backpack", 7733271, CreativeCategory.ITEMS);

        //
        // SLIME BALL
        //
        register("minecraft:slime_ball", "slime_bucket", 7733268, CreativeCategory.ITEMS);
        register("minecraft:slime_ball", "slime_bucket_excited", 7733269, CreativeCategory.ITEMS);

        //
        // STONE HOE
        //
        register("minecraft:stone_hoe", "stone_sickle", 7733253, CreativeCategory.EQUIPMENT);

        //
        // WARPED FUNGUS ON A STICK
        //
        register("minecraft:warped_fungus_on_a_stick", "home_scroll", 7733248, CreativeCategory.EQUIPMENT);
        register("minecraft:warped_fungus_on_a_stick", "unstable_scroll", 7733249, CreativeCategory.EQUIPMENT);
        register("minecraft:warped_fungus_on_a_stick", "file", 7733251, CreativeCategory.EQUIPMENT);
        register("minecraft:warped_fungus_on_a_stick", "trowel", 7733262, CreativeCategory.EQUIPMENT);
        register("minecraft:warped_fungus_on_a_stick", "spawn_scroll", 7733264, CreativeCategory.EQUIPMENT);
        register("minecraft:warped_fungus_on_a_stick", "lodestone_scroll", 7733265, CreativeCategory.EQUIPMENT);
        register("minecraft:warped_fungus_on_a_stick", "death_scroll", 7733266, CreativeCategory.EQUIPMENT);

        //
        // WOODEN HOE
        //
        register("minecraft:wooden_hoe", "wooden_sickle", 7733252, CreativeCategory.EQUIPMENT);
    }

    private void register(String vanilla, String name, int modelData, CreativeCategory category) {
        CustomItemData item = CustomItemData.builder()
                .name(name)
                .customItemOptions(CustomItemOptions.builder()
                        .customModelData(modelData)
                        .build())
                .textureSize(16)
                .creativeCategory(category.id())
                .build();

        geyserApi().customItemRegistry().register(vanilla, item);
    }

    @Subscribe
    public void onResourcePacks(GeyserDefineResourcePacksEvent event) {
        logger().info("Loading: " + event.resourcePacks().size() + " resource packs.");
    }
}
