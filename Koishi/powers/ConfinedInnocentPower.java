/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.LoseHPAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class ConfinedInnocentPower extends AbstractPower {
/* 14 */   private int HP_LOSS = 1;
/*    */   
/* 16 */   public static final String POWER_ID = KoishiMod.makeID("ConfinedInnocentPower");
/* 17 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 18 */   public static final String NAME = powerStrings.NAME;
/* 19 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public ConfinedInnocentPower(AbstractCreature owner, int amount) {
/* 22 */     this.name = NAME;
/* 23 */     this.ID = POWER_ID;
/*    */     
/* 25 */     this.owner = owner;
/* 26 */     this.amount = amount;
/*    */     
/* 28 */     this.type = AbstractPower.PowerType.BUFF;
/* 29 */     this.isTurnBased = false;
/*    */     
/* 31 */     loadRegion("juggernaut");
/*    */     
/* 33 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 38 */     this.HP_LOSS++;
/* 39 */     super.stackPower(stackAmount);
/*    */   }
/*    */ 
/*    */   
/*    */   public void reducePower(int reduceAmount) {
/* 44 */     this.HP_LOSS--;
/* 45 */     super.reducePower(reduceAmount);
/*    */   }
/*    */ 
/*    */   
/*    */   public void atStartOfTurnPostDraw() {
/* 50 */     flash();
/* 51 */     for (int i = 0; i < this.HP_LOSS; i++) {
/* 52 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new LoseHPAction(this.owner, this.owner, 1));
/*    */     }
/* 54 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, new EphemeralPower(this.owner, this.amount), this.amount));
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 59 */     if (this.HP_LOSS == 1) {
/* 60 */       this.description = DESCRIPTIONS[0] + this.HP_LOSS + DESCRIPTIONS[1] + DESCRIPTIONS[3] + this.amount + DESCRIPTIONS[4];
/*    */     } else {
/* 62 */       this.description = DESCRIPTIONS[0] + this.HP_LOSS + DESCRIPTIONS[2] + DESCRIPTIONS[3] + this.amount + DESCRIPTIONS[4];
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/ConfinedInnocentPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */