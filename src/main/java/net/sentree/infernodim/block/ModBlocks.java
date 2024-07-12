package net.sentree.infernodim.block;


import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.infernodim.InfernoMod;
import net.sentree.infernodim.block.custom.CustomSaplingBlock;
import net.sentree.infernodim.block.custom.ModFlammableRotatedPillarBlock;
import net.sentree.infernodim.block.custom.ModPortalBlock;
import net.sentree.infernodim.item.ModItems;
import net.sentree.infernodim.worldgen.tree.BlazeTreeGrower;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, InfernoMod.MOD_ID);

    public static final RegistryObject<Block> INFERNO_DEBRIS = registerBlock("inferno_debris",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS).mapColor(DyeColor.ORANGE)));

    public static final RegistryObject<Block> INFERNO_BLOCK = registerBlock("inferno_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.COLOR_ORANGE)));

    public static final RegistryObject<Block> ASH_BLOCK = registerBlock("ash_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND).mapColor(MapColor.COLOR_GRAY)));

    public static final RegistryObject<Block> HARDENED_ASH_BLOCK = registerBlock("hardened_ash_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_GRAY)));





    public static final RegistryObject<Block> BLAZE_LOG = registerBlock("blaze_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(4f)));
    public static final RegistryObject<Block> BLAZE_WOOD = registerBlock("blaze_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(4f)));
    public static final RegistryObject<Block> STRIPPED_BLAZE_LOG = registerBlock("stripped_blaze_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final RegistryObject<Block> STRIPPED_BLAZE_WOOD = registerBlock("stripped_blaze_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public static final RegistryObject<Block> BLAZE_PLANKS = registerBlock("blaze_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return false;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 0;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 0;
                }
            });
    public static final RegistryObject<Block> BLAZE_LEAVES = registerBlock("blaze_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return false;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 0;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 0;
                }
            });

    public static final RegistryObject<Block> BLAZE_SAPLING = registerBlock("blaze_sapling",
            () -> new CustomSaplingBlock(new BlazeTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));





    public static final RegistryObject<Block> INFERNO_PORTAL = registerBlock("inferno_portal",
            () -> new ModPortalBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_ORANGE).noLootTable().noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
