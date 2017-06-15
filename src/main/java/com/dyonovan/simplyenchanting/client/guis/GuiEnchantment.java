package com.dyonovan.simplyenchanting.client.guis;

import com.dyonovan.simplyenchanting.common.Containers.ContainerEnchantment;
import com.dyonovan.simplyenchanting.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * This file was created for SimplyEnchanting
 * <p>
 * SimplyEnchanting is licensed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 *
 * @author Dyonovan
 * @since 6/15/2017
 */
public class GuiEnchantment extends GuiContainer {

    public GuiEnchantment(ContainerEnchantment inventorySlotsIn) {
        super(inventorySlotsIn);

        this.xSize = 175;
        this.ySize = 165;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.pushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GlStateManager.translate(guiLeft, guiTop, 0);

        Minecraft.getMinecraft().getTextureManager().bindTexture( new ResourceLocation(Reference.MOD_ID, "textures/gui/guienchanting.png"));
        drawTexturedModalRect(0, 0, 0, 0, xSize + 1, ySize + 1);

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.enableStandardItemLighting();
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.popMatrix();
    }

    @Override
    public void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String title = I18n.format("simplyenchanting:guiEnchantment");
        int strWidth = this.fontRendererObj.getStringWidth(title);
        int displayPos = xSize / 2 - (strWidth / 2);
        this.fontRendererObj.drawString(title, displayPos, 3, 4210752);
    }
}
