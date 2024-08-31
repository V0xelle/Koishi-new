/*    */ package Koishi.relics;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.util.TextureLoader;
/*    */ import basemod.abstracts.CustomRelic;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ 
/*    */ public class AHoleWhereASisterShouldBe
/*    */   extends CustomRelic
/*    */ {
/* 19 */   public static final String ID = KoishiMod.makeID("AHoleWhereASisterShouldBe");
/*    */   
/* 21 */   private static final Texture IMG = TextureLoader.getTexture(KoishiMod.makeRelicPath("AHoleWhereASisterShouldBe.png"));
/* 22 */   private static final Texture OUTLINE = TextureLoader.getTexture(KoishiMod.makeRelicOutlinePath("AHoleWhereASisterShouldBe.png"));
/*    */   
/*    */   private static final int EFFECT = 1;
/*    */   private boolean triggered = false;
/*    */   
/*    */   public AHoleWhereASisterShouldBe() {
/* 28 */     super(ID, IMG, OUTLINE, AbstractRelic.RelicTier.COMMON, AbstractRelic.LandingSound.SOLID);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCardDraw(AbstractCard drawnCard) {
/* 33 */     if (!this.triggered && drawnCard instanceof Koishi.cards.AbstractIdCard) {
/* 34 */       flash();
/* 35 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, (AbstractRelic)this));
/* 36 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainEnergyAction(1));
/* 37 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DrawCardAction((AbstractCreature)AbstractDungeon.player, 1));
/* 38 */       this.triggered = true;
/* 39 */       this.pulse = false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void atTurnStart() {
/* 45 */     if (!this.triggered) {
/* 46 */       beginPulse();
/* 47 */       this.pulse = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void onVictory() {
/* 53 */     this.triggered = false;
/* 54 */     this.pulse = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUpdatedDescription() {
/* 59 */     return this.DESCRIPTIONS[0] + '\001' + this.DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/relics/AHoleWhereASisterShouldBe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */