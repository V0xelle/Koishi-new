/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class BloodlustPower
/*    */   extends AbstractPower {
/* 15 */   public static final String POWER_ID = KoishiMod.makeID("BloodlustPower");
/* 16 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 17 */   public static final String NAME = powerStrings.NAME;
/* 18 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public BloodlustPower(AbstractCreature owner, int amount) {
/* 21 */     this.name = NAME;
/* 22 */     this.ID = POWER_ID;
/*    */     
/* 24 */     this.owner = owner;
/* 25 */     this.amount = amount;
/*    */     
/* 27 */     this.type = AbstractPower.PowerType.DEBUFF;
/* 28 */     this.isTurnBased = false;
/*    */ 
/*    */     
/* 31 */     loadRegion("brutality");
/*    */     
/* 33 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void atStartOfTurnPostDraw() {
/* 38 */     flash();
/* 39 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new LoseEnergyAction(this.amount));
/* 40 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 46 */     this.description = DESCRIPTIONS[0];
/* 47 */     for (int i = 0; i < this.amount; i++) {
/* 48 */       this.description += " [E]";
/*    */     }
/* 50 */     this.description += DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/BloodlustPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */