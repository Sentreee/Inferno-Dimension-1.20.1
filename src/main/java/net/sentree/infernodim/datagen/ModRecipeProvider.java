package net.sentree.infernodim.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.sentree.infernodim.InfernoMod;
import net.sentree.infernodim.block.ModBlocks;
import net.sentree.infernodim.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> INFERNO_SMELATBLES = List.of(ModBlocks.INFERNO_DEBRIS.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, INFERNO_SMELATBLES, RecipeCategory.MISC, ModItems.INFERNO_SCRAP.get(), 1f,200, "inferno");
        oreSmelting(pWriter, INFERNO_SMELATBLES, RecipeCategory.MISC, ModItems.INFERNO_SCRAP.get(), 1f,400, "inferno");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INFERNO_BLOCK.get())
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', ModItems.INFERNO_INGOT.get())
                .unlockedBy(getHasName(ModItems.INFERNO_INGOT.get()), has(ModItems.INFERNO_INGOT.get()))
                .save(pWriter);

        //ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.INFERNO_INGOT.get(), 9)
        //        .requires(ModBlocks.INFERNO_BLOCK.get())
        //        .unlockedBy(getHasName(ModBlocks.INFERNO_BLOCK.get()), has(ModBlocks.INFERNO_BLOCK.get()))
        //        .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INFERNO_INGOT.get())
                .pattern("SSS")
                .pattern("SBB")
                .pattern("BBL")
                .define('S', ModItems.INFERNO_SCRAP.get())
                .define('B', Items.BLAZE_ROD)
                .define('L', Items.LAVA_BUCKET)
                .unlockedBy(getHasName(ModItems.INFERNO_SCRAP.get()), has(ModItems.INFERNO_SCRAP.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, InfernoMod.MOD_ID + ":" + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
