/*    */ package Koishi.vfx;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.badlogic.gdx.math.Interpolation;
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.helpers.ImageMaster;
/*    */ import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
/*    */ 
/*    */ public class ForceIntentChangePreviewEffect
/*    */   extends AbstractGameEffect
/*    */ {
/*    */   private float effectDuration;
/*    */   private float cx;
/*    */   private float cy;
/*    */   private float x;
/*    */   private float y;
/*    */   private float sX;
/*    */   private float sY;
/*    */   private float tX;
/*    */   private float tY;
/* 25 */   private TextureAtlas.AtlasRegion img = ImageMaster.GLOW_SPARK_2;
/*    */ 
/*    */   
/*    */   public ForceIntentChangePreviewEffect(float x, float y, float duration, float scale) {
/* 29 */     this.effectDuration = duration;
/* 30 */     this.duration = this.effectDuration;
/* 31 */     this.startingDuration = this.effectDuration;
/*    */     
/* 33 */     this.cx = x;
/* 34 */     this.cy = y;
/*    */     
/* 36 */     this.x = x + MathUtils.random(-30.0F, 30.0F) * Settings.scale * scale;
/* 37 */     this.y = y + MathUtils.random(-30.0F, 30.0F) * Settings.scale * scale;
/* 38 */     this.sX = this.x;
/* 39 */     this.sY = this.y;
/* 40 */     this.tX = x;
/* 41 */     this.tY = y;
/*    */     
/* 43 */     this.scale = MathUtils.random(0.3F, 1.2F) * Settings.scale * scale;
/* 44 */     this.renderBehind = true;
/*    */     
/* 46 */     int tmp = MathUtils.random(5);
/* 47 */     if (tmp == 0) {
/* 48 */       this.color = Color.RED.cpy();
/* 49 */       this.scale /= 4.0F;
/* 50 */     } else if (tmp < 3) {
/* 51 */       this.color = Color.BLACK.cpy();
/*    */     } else {
/* 53 */       this.color = Color.GREEN.cpy();
/*    */     } 
/* 55 */     this.color.a = 0.25F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {
/* 60 */     float s = MathUtils.sin(0.04F);
/* 61 */     float c = MathUtils.cos(0.04F);
/*    */     
/* 63 */     this.rotation += 4.0F;
/*    */ 
/*    */     
/* 66 */     this.sX -= this.cx;
/* 67 */     this.sY -= this.cy;
/*    */ 
/*    */     
/* 70 */     float xnew = this.sX * c - this.sY * s;
/* 71 */     float ynew = this.sX * s + this.sY * c;
/*    */ 
/*    */     
/* 74 */     this.sX = xnew + this.cx;
/* 75 */     this.sY = ynew + this.cy;
/*    */     
/* 77 */     this.x = Interpolation.swingOut.apply(this.tX, this.sX, this.duration * 1.5F);
/* 78 */     this.y = Interpolation.swingOut.apply(this.tY, this.sY, this.duration * 1.5F);
/*    */     
/* 80 */     super.update();
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SpriteBatch sb) {
/* 85 */     sb.setColor(this.color);
/* 86 */     sb.setBlendFunction(770, 771);
/* 87 */     sb.draw((TextureRegion)this.img, this.x - this.img.packedWidth / 2.0F, this.y - this.img.packedWidth / 2.0F, this.img.packedWidth / 2.0F, this.img.packedHeight / 2.0F, this.img.packedWidth, this.img.packedHeight, this.scale * 
/*    */         
/* 89 */         MathUtils.random(0.7F, 1.4F), this.scale * 
/* 90 */         MathUtils.random(0.7F, 1.4F), this.rotation);
/*    */     
/* 92 */     sb.setBlendFunction(770, 771);
/*    */   }
/*    */   
/*    */   public void dispose() {}
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/vfx/ForceIntentChangePreviewEffect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */