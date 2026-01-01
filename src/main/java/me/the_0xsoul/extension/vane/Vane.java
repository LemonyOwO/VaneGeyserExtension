package me.the_0xsoul.extension.vane;

import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.event.lifecycle.*;
import org.geysermc.geyser.api.extension.Extension;
import org.geysermc.geyser.api.item.custom.CustomItemData;
import org.geysermc.geyser.api.item.custom.CustomItemOptions;
import org.geysermc.geyser.api.util.CreativeCategory;

import java.nio.file.Path;
import java.util.function.BiConsumer;

public class Vane implements Extension {

    @Subscribe
    public void onPreInitialize(GeyserPreInitializeEvent event) {
        logger().info("");
        logger().info("##############################################");
        logger().info("Vane Geyser Extension");
        logger().info("Made by: 0xSoul, updated to Geyser 2.9+ by LemonyOwO");
        logger().info("##############################################");
        logger().info("");
    }

    @Subscribe
    public void onGeyserPreInitializeEvent(GeyserDefineCustomItemsEvent event) {
        BiConsumer<String, CustomItemData> registerItem = (id, item) -> {
            event.register(id, item);
            logger().info("Registered custom item: " + item.name() + " -> " + id);
        };

        // ---------------- BOOKS ----------------
        registerItem.accept("minecraft:book", CustomItemData.builder()
                .name("ancient_tome")
                .customItemOptions(CustomItemOptions.builder().customModelData(7798784).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build());

        registerItem.accept("minecraft:book", CustomItemData.builder()
                .name("ancient_tome_of_knowledge")
                .customItemOptions(CustomItemOptions.builder().customModelData(7798786).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build());

        registerItem.accept("minecraft:book", CustomItemData.builder()
                .name("ancient_tome_of_the_gods")
                .customItemOptions(CustomItemOptions.builder().customModelData(7798788).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build());

        // ---------------- ENCHANTED BOOKS ----------------
        registerItem.accept("minecraft:enchanted_book", CustomItemData.builder()
                .name("enchanted_ancient_tome")
                .customItemOptions(CustomItemOptions.builder().customModelData(7798785).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build());

        registerItem.accept("minecraft:enchanted_book", CustomItemData.builder()
                .name("enchanted_ancient_tome_of_knowledge")
                .customItemOptions(CustomItemOptions.builder().customModelData(7798787).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build());

        registerItem.accept("minecraft:enchanted_book", CustomItemData.builder()
                .name("enchanted_ancient_tome_of_the_gods")
                .customItemOptions(CustomItemOptions.builder().customModelData(7798789).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build());

        // ---------------- HOES / SICKLES ----------------
        registerItem.accept("minecraft:wooden_hoe", CustomItemData.builder()
                .name("wooden_sickle")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733252).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:stone_hoe", CustomItemData.builder()
                .name("stone_sickle")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733253).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:iron_hoe", CustomItemData.builder()
                .name("iron_sickle")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733254).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:golden_hoe", CustomItemData.builder()
                .name("golden_sickle")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733255).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:diamond_hoe", CustomItemData.builder()
                .name("diamond_sickle")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733256).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:netherite_hoe", CustomItemData.builder()
                .name("netherite_sickle")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733257).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        // ---------------- GLASS BOTTLES / XP ----------------
        registerItem.accept("minecraft:glass_bottle", CustomItemData.builder()
                .name("empty_xp_bottle")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733258).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:glass_bottle", CustomItemData.builder()
                .name("small_xp_bottle")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733259).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build());

        registerItem.accept("minecraft:glass_bottle", CustomItemData.builder()
                .name("medium_xp_bottle")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733260).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:glass_bottle", CustomItemData.builder()
                .name("large_xp_bottle")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733261).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        // ---------------- OTHER ITEMS ----------------
        registerItem.accept("minecraft:warped_fungus_on_a_stick", CustomItemData.builder()
                .name("home_scroll")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733248).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:warped_fungus_on_a_stick", CustomItemData.builder()
                .name("unstable_scroll")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733249).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:elytra", CustomItemData.builder()
                .name("reinforced_elytra")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733250).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:warped_fungus_on_a_stick", CustomItemData.builder()
                .name("file")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733251).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:dropper", CustomItemData.builder()
                .name("pouch")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733270).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build());

        registerItem.accept("minecraft:shulker_box", CustomItemData.builder()
                .name("backpack")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733271).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build());

        registerItem.accept("minecraft:slime_ball", CustomItemData.builder()
                .name("slime_bucket")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733268).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build());

        registerItem.accept("minecraft:slime_ball", CustomItemData.builder()
                .name("slime_bucket_excited")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733269).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build());

        registerItem.accept("minecraft:warped_fungus_on_a_stick", CustomItemData.builder()
                .name("trowel")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733262).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:paper", CustomItemData.builder()
                .name("papyrus_scroll")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733263).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build());

        registerItem.accept("minecraft:warped_fungus_on_a_stick", CustomItemData.builder()
                .name("spawn_scroll")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733264).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:warped_fungus_on_a_stick", CustomItemData.builder()
                .name("lodestone_scroll")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733265).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());

        registerItem.accept("minecraft:warped_fungus_on_a_stick", CustomItemData.builder()
                .name("death_scroll")
                .customItemOptions(CustomItemOptions.builder().customModelData(7733266).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.EQUIPMENT.id())
                .build());
    }

    @Subscribe
    public void onGeyserLoadResourcePacksEvent(GeyserDefineResourcePacksEvent event) {
        logger().info("Resource packs are loaded automatically from the server's packs folder.");
    }

    @Subscribe
    public void onPostInitialize(GeyserPostInitializeEvent event) {
        logger().info("Vane extension fully loaded!");
        Path exampleDataFolder = this.dataFolder();
        logger().info("Extension data folder: " + exampleDataFolder.toString());
    }

    @Subscribe
    public void onGeyserReload(GeyserPreInitializeEvent event) {
        logger().info("Reloading Vane extension!");
    }
}
