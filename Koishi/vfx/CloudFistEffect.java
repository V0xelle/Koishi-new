/*    */ package Koishi.vfx;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.badlogic.gdx.math.Interpolation;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
/*    */ 
/*    */ public class CloudFistEffect
/*    */   extends AbstractGameEffect {
/* 15 */   public static final String CLOUD_FIST = KoishiMod.makeEffectPath("Cloud Fist.png");
/* 16 */   private static final Texture CLOUD_FIST_TEXTURE = new Texture(CLOUD_FIST);
/*    */   
/*    */   private TextureRegion CLOUD_FIST_REGION;
/*    */   
/*    */   private static final float DURATION = 0.8F;
/*    */   
/*    */   private float x;
/*    */   private float y;
/*    */   private float offset;
/*    */   private float graphicsAnimation;
/*    */   private float scaleWidth;
/*    */   private float scaleHeight;
/*    */   
/*    */   public CloudFistEffect(float x, float y) {
/* 30 */     this.x = x;
/* 31 */     this.y = y;
/*    */     
/* 33 */     this.CLOUD_FIST_REGION = new TextureRegion(CLOUD_FIST_TEXTURE);
/*    */     
/* 35 */     this.color = Color.WHITE.cpy();
/* 36 */     this.color.a = 0.0F;
/* 37 */     this.duration = this.startingDuration = 0.8F;
/* 38 */     this.graphicsAnimation = 0.0F;
/* 39 */     this.offset = this.CLOUD_FIST_REGION.getRegionHeight();
/*    */     
/* 41 */     this.scaleWidth = 1.0F * Settings.scale;
/* 42 */     this.scaleHeight = Settings.scale;
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {
/* 47 */     this.duration -= Gdx.graphics.getDeltaTime();
/* 48 */     this.graphicsAnimation += Gdx.graphics.getDeltaTime();
/* 49 */     if (this.graphicsAnimation <= 0.5F) {
/*    */       
/* 51 */       this.color.a = this.graphicsAnimation * 0.8F;
/* 52 */       if (this.color.a > 1.0F) {
/* 53 */         this.color.a = 1.0F;
/*    */       }
/*    */     } 
/* 56 */     if (this.graphicsAnimation <= 0.8F) {
/* 57 */       this.offset = Interpolation.fade.apply(this.CLOUD_FIST_REGION.getRegionHeight(), (0.0F - this.CLOUD_FIST_REGION.getRegionHeight()) / 4.0F, (this.graphicsAnimation + 1.0F) / 1.5F);
/*    */     }
/* 59 */     if (this.duration <= 0.0F) {
/* 60 */       this.isDone = true;
/*    */     }
/*    */   }
/*    */   
/*    */   public void render(SpriteBatch sb) {
/* 65 */     sb.setColor(this.color);
/* 66 */     sb.draw(this.CLOUD_FIST_REGION, this.x - this.CLOUD_FIST_REGION.getRegionWidth() * this.scaleWidth / 2.0F, this.y + this.offset * this.scaleHeight, 0.0F, 0.0F, this.CLOUD_FIST_REGION.getRegionWidth(), this.CLOUD_FIST_REGION.getRegionHeight(), this.scaleWidth, this.scaleHeight, 0.0F);
/*    */   }
/*    */   
/*    */   public void dispose() {}
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/vfx/CloudFistEffect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */