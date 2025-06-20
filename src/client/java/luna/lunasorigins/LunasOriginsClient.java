package luna.lunasorigins;

import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import luna.lunasorigins.entity.CrimsonPhantomRender;
import luna.lunasorigins.entity.HostileAxolotlRender;
import luna.lunasorigins.entity.LunaBlockEntities;
import luna.lunasorigins.entity.LunaEntities;
import luna.lunasorigins.particle.ElectricSparkParticleFactory;
import luna.lunasorigins.particle.ModParticleFactories;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;

public class LunasOriginsClient implements ClientModInitializer {
        public static final String MOD_ID = "lunasorigins";
        public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

        @Override
        public void onInitializeClient() {

                LOGGER.info("WORKS!!!");
                ParticleFactoryRegistry.getInstance().register(LunaParticles.RED_FLAME, FlameParticle.Factory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.YELLOW_FLAME, FlameParticle.Factory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.GREEN_FLAME, FlameParticle.Factory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.BLUE_FLAME, FlameParticle.Factory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.PURPLE_FLAME, FlameParticle.Factory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.WHITE_FLAME, FlameParticle.Factory::new);

                ParticleFactoryRegistry.getInstance().register(LunaParticles.BLUE_SPARK,
                                ElectricSparkParticleFactory.BlueElectricSparkFactory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.ORANGE_SPARK,
                                ElectricSparkParticleFactory.OrangeElectricSparkFactory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.GEM_SPARK,
                                ElectricSparkParticleFactory.GemElectricSparkFactory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.BLUE_DRIPPING_OBSIDIAN_TEAR,
                                ModParticleFactories.DrippingBlueObsidianTearFactory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.BLUE_FALLING_OBSIDIAN_TEAR,
                                ModParticleFactories.FallingBlueObsidianTearFactory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.BLUE_LANDING_OBSIDIAN_TEAR,
                                ModParticleFactories.LandingBlueObsidianTearFactory::new);
                // BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.BLOCK, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.DIMENSIONAL_BERRY_BUSH_BLOCK, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.SOUL_BERRY_BUSH_BLOCK, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.COMMAND_LEAVES_PINK, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.COMMAND_LEAVES_GREEN, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.COMMAND_LEAVES_RED, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.COMMAND_LEAVES_YELLOW, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.COMMAND_LEAVES_PINK, RenderLayer.getTranslucent());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.COMMAND_LEAVES_GREEN, RenderLayer.getTranslucent());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.COMMAND_LEAVES_RED, RenderLayer.getTranslucent());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.COMMAND_LEAVES_YELLOW, RenderLayer.getTranslucent());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.DROP_POINT, RenderLayer.getTranslucent());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.ENDER_FIRE, RenderLayer.getTranslucent());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.COMMAND_DOOR, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.COMMAND_TRAPDOOR, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.PINK_COMMAND_SAPLING, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.GREEN_COMMAND_SAPLING, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.RED_COMMAND_SAPLING, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.YELLOW_COMMAND_SAPLING, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.NOCTILITH, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.WHITE_LILY, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.DROP_POINT, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.ENDER_FIRE, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.RED_WISP_LANTERN, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.ORANGE_WISP_LANTERN, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.YELLOW_WISP_LANTERN, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.GREEN_WISP_LANTERN, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.CYAN_WISP_LANTERN, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.BLUE_WISP_LANTERN, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.PURPLE_WISP_LANTERN, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.WHITE_WISP_LANTERN, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(LunaBlocks.LANTERN_CASING, RenderLayer.getCutout());
                EntityRendererRegistry.register(LunaEntities.CRIMSON_PHANTOM, CrimsonPhantomRender::new);
                EntityRendererRegistry.register(LunaEntities.HOSTILE_AXOLOTL, HostileAxolotlRender::new);
                BlockEntityRendererFactories.register(LunaBlockEntities.COMMAND_SIGN,
                                SignBlockEntityRenderer::new);
                BlockEntityRendererFactories.register(LunaBlockEntities.COMMAND_HANGING_SIGN,
                                HangingSignBlockEntityRenderer::new);

        }

        public static KeyBinding nullary = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                        "key.lunasorigins.nullary",
                        GLFW.GLFW_KEY_0,
                        "category.origins"));

}
