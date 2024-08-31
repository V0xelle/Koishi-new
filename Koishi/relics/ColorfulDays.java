/*    */ package Koishi.relics;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.util.TextureLoader;
/*    */ import basemod.abstracts.CustomRelic;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ColorfulDays
/*    */   extends CustomRelic
/*    */ {
/* 15 */   public static final String ID = KoishiMod.makeID("ColorfulDays");
/*    */   
/* 17 */   private static final Texture IMG = TextureLoader.getTexture(KoishiMod.makeRelicPath("ColorfulDays.png"));
/* 18 */   private static final Texture OUTLINE = TextureLoader.getTexture(KoishiMod.makeRelicOutlinePath("ColorfulDays.png"));
/*    */   
/*    */   public static final int EPHEMERAL_INCREASE = 20;
/*    */   
/*    */   public ColorfulDays() {
/* 23 */     super(ID, IMG, OUTLINE, AbstractRelic.RelicTier.BOSS, AbstractRelic.LandingSound.MAGICAL);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onEquip() {
/* 28 */     AbstractDungeon.player.energy.energyMaster++;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onUnequip() {
/* 33 */     AbstractDungeon.player.energy.energyMaster--;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUpdatedDescription() {
/* 38 */     return this.DESCRIPTIONS[0] + '\024' + this.DESCRIPTIONS[1] + '\017' + this.DESCRIPTIONS[2];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/relics/ColorfulDays.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */