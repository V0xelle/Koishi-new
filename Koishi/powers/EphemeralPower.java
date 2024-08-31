/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.relics.ColorfulDays;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
/*    */ 
/*    */ public class EphemeralPower extends AbstractPower {
/* 16 */   public static final String POWER_ID = KoishiMod.makeID("EphemeralPower");
/* 17 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 18 */   public static final String NAME = powerStrings.NAME;
/* 19 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public static final int ORIGINAL_THRESHOLD = 15;
/* 22 */   public static int threshold = 15;
/* 23 */   public static int intangible = 1;
/*    */   
/*    */   public EphemeralPower(AbstractCreature owner, int amount) {
/* 26 */     this.name = NAME;
/* 27 */     this.ID = POWER_ID;
/*    */     
/* 29 */     this.owner = owner;
/* 30 */     this.amount = amount;
/*    */     
/* 32 */     this.type = AbstractPower.PowerType.BUFF;
/* 33 */     this.isTurnBased = false;
/*    */     
/* 35 */     loadRegion("wraithForm");
/*    */     
/* 37 */     updateDescription();
/* 38 */     checkTrigger();
/*    */   }
/*    */ 
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 43 */     this.fontScale = 8.0F;
/* 44 */     this.amount += stackAmount;
/* 45 */     updateDescription();
/* 46 */     checkTrigger();
/* 47 */     if (this.amount == 0) {
/* 48 */       AbstractDungeon.actionManager.addToTop((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 54 */     this.description = DESCRIPTIONS[0] + threshold + DESCRIPTIONS[1] + intangible + DESCRIPTIONS[2];
/*    */   }
/*    */   
/*    */   public void checkTrigger() {
/* 58 */     if (AbstractDungeon.player.hasRelic(ColorfulDays.ID)) {
/* 59 */       threshold = 20;
/*    */     } else {
/* 61 */       threshold = 15;
/*    */     } 
/* 63 */     updateDescription();
/* 64 */     if (this.amount / threshold >= 1) {
/* 65 */       flash();
/* 66 */       stackPower(-threshold);
/* 67 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, (AbstractPower)new IntangiblePlayerPower(this.owner, intangible), intangible));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/EphemeralPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */