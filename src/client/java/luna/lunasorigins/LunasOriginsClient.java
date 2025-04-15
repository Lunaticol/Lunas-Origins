package luna.lunasorigins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import luna.lunasorigins.entity.CrimsonPhantomRender;
import luna.lunasorigins.entity.HostileAxolotlRender;
import luna.lunasorigins.entity.LunaEntities;
import luna.lunasorigins.particle.ModParticleFactories;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.RenderLayer;

public class LunasOriginsClient implements ClientModInitializer {
        public static final String MOD_ID = "lunasorigins";
        public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

        @Override
        public void onInitializeClient() {
                registerThroughParticleFactoryRegistry();

                LOGGER.info("WORKS!!!");
                ParticleFactoryRegistry.getInstance().register(LunaParticles.RED_FLAME, FlameParticle.Factory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.YELLOW_FLAME, FlameParticle.Factory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.GREEN_FLAME, FlameParticle.Factory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.BLUE_FLAME, FlameParticle.Factory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.PURPLE_FLAME, FlameParticle.Factory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.WHITE_FLAME, FlameParticle.Factory::new);
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
                // BlockEntityRendererFactories.register(LunaBlockEntity.HANGING_SIGN, SignBlockEntityRenderer::new);
                // EntityRendererRegistry.register(LunaEntities.ENTITY, EntityRender::new);
                EntityRendererRegistry.register(LunaEntities.CRIMSON_PHANTOM, CrimsonPhantomRender::new);
                EntityRendererRegistry.register(LunaEntities.HOSTILE_AXOLOTL, HostileAxolotlRender::new);
        }

        private void registerThroughParticleFactoryRegistry() {
                ParticleFactoryRegistry.getInstance().register(LunaParticles.BLUE_DRIPPING_OBSIDIAN_TEAR,
                                ModParticleFactories.DrippingBlueObsidianTearFactory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.BLUE_FALLING_OBSIDIAN_TEAR,
                                ModParticleFactories.FallingBlueObsidianTearFactory::new);
                ParticleFactoryRegistry.getInstance().register(LunaParticles.BLUE_LANDING_OBSIDIAN_TEAR,
                                ModParticleFactories.LandingBlueObsidianTearFactory::new);
        }
}
