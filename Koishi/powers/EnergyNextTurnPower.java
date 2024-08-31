/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class EnergyNextTurnPower extends AbstractPower {
/* 14 */   public static final String POWER_ID = KoishiMod.makeID("EnergyNextTurnPower");
/* 15 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 16 */   public static final String NAME = powerStrings.NAME;
/* 17 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public EnergyNextTurnPower(AbstractCreature owner, int amount) {
/* 20 */     this.name = NAME;
/* 21 */     this.ID = POWER_ID;
/*    */     
/* 23 */     this.owner = owner;
/* 24 */     this.amount = amount;
/*    */     
/* 26 */     this.type = AbstractPower.PowerType.BUFF;
/* 27 */     this.isTurnBased = false;
/*    */ 
/*    */     
/* 30 */     loadRegion("energized_green");
/*    */     
/* 32 */     updateDescription();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 38 */     this.description = DESCRIPTIONS[0];
/* 39 */     for (int i = 0; i < this.amount; i++) {
/* 40 */       this.description += " [E]";
/*    */     }
/* 42 */     this.description += DESCRIPTIONS[1];
/*    */   }
/*    */ 
/*    */   
/*    */   public void onEnergyRecharge() {
/* 47 */     flash();
/* 48 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainEnergyAction(this.amount));
/* 49 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/EnergyNextTurnPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */