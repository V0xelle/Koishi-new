/*    */ package Koishi.relics;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.util.TextureLoader;
/*    */ import basemod.abstracts.CustomRelic;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ 
/*    */ public class TeethAndClaws
/*    */   extends CustomRelic
/*    */ {
/* 17 */   public static final String ID = KoishiMod.makeID("TeethAndClaws");
/*    */   
/* 19 */   private static final Texture IMG = TextureLoader.getTexture(KoishiMod.makeRelicPath("TeethAndClaws.png"));
/* 20 */   private static final Texture OUTLINE = TextureLoader.getTexture(KoishiMod.makeRelicOutlinePath("TeethAndClaws.png"));
/*    */   
/*    */   private static final int BLOCK = 6;
/*    */   private boolean triggered = false;
/*    */   
/*    */   public TeethAndClaws() {
/* 26 */     super(ID, IMG, OUTLINE, AbstractRelic.RelicTier.UNCOMMON, AbstractRelic.LandingSound.HEAVY);
/* 27 */     this.pulse = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onTrigger(AbstractCreature target) {
/* 32 */     if (!this.triggered) {
/* 33 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, (AbstractRelic)this));
/* 34 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction(target, target, 6));
/* 35 */       this.pulse = false;
/* 36 */       this.triggered = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void atTurnStart() {
/* 42 */     beginPulse();
/* 43 */     this.pulse = true;
/* 44 */     this.triggered = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onVictory() {
/* 49 */     this.triggered = false;
/* 50 */     this.pulse = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUpdatedDescription() {
/* 55 */     return this.DESCRIPTIONS[0] + '\006' + this.DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/relics/TeethAndClaws.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */