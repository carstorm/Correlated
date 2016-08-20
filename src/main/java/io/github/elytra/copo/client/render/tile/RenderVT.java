package io.github.elytra.copo.client.render.tile;

import org.lwjgl.opengl.GL11;

import io.github.elytra.copo.CoPo;
import io.github.elytra.copo.block.BlockVT;
import io.github.elytra.copo.tile.TileEntityVT;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;

public class RenderVT extends TileEntitySpecialRenderer<TileEntityVT> {

	@Override
	public void renderTileEntityAt(TileEntityVT te, double x, double y, double z, float partialTicks, int destroyStage) {
		IBlockState bs = te.getWorld().getBlockState(te.getPos());
		if (bs.getBlock() != CoPo.vt || !bs.getValue(BlockVT.lit)) return;

		GlStateManager.pushMatrix();
		GlStateManager.translate(x, y, z);

		EnumFacing facing = bs.getValue(BlockVT.facing);
		switch (facing) {
			case NORTH:
				break;
			case WEST:
				GlStateManager.rotate(90, 0, 1, 0);
				GlStateManager.translate(-1, 0, 0);
				break;
			case SOUTH:
				GlStateManager.rotate(180, 0, 1, 0);
				GlStateManager.translate(-1, 0, -1);
				break;
			case EAST:
				GlStateManager.rotate(270, 0, 1, 0);
				GlStateManager.translate(0, 0, -1);
				break;
			default:
				break;
		}
		GlStateManager.translate(0, 0, -0.005f);

		GlStateManager.color(1, 1, 1);

		float lastX = OpenGlHelper.lastBrightnessX;
		float lastY = OpenGlHelper.lastBrightnessY;
		Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240, 240);
		GlStateManager.disableLighting();

		TextureAtlasSprite tas = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("correlatedpotentialistics:blocks/vt");
		float minU = tas.getMinU();
		float maxU = tas.getMaxU();
		float minV = tas.getMinV();
		float maxV = tas.getMaxV();

		Tessellator tess = Tessellator.getInstance();
		VertexBuffer wr = tess.getBuffer();
		wr.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
		wr.pos(0, 0, 0).tex(maxU, maxV).endVertex();
		wr.pos(0, 1, 0).tex(maxU, minV).endVertex();
		wr.pos(1, 1, 0).tex(minU, minV).endVertex();
		wr.pos(1, 0, 0).tex(minU, maxV).endVertex();
		tess.draw();

		GlStateManager.enableLighting();
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lastX, lastY);

		GlStateManager.popMatrix();
	}

}
