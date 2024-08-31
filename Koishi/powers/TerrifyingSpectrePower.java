/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class TerrifyingSpectrePower extends AbstractPower {
/* 13 */   public static final String POWER_ID = KoishiMod.makeID("TerrifyingSpectrePower");
/* 14 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 15 */   public static final String NAME = powerStrings.NAME;
/* 16 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public TerrifyingSpectrePower(AbstractCreature owner, int amount) {
/* 19 */     this.name = NAME;
/* 20 */     this.ID = POWER_ID;
/*    */     
/* 22 */     this.owner = owner;
/* 23 */     this.amount = amount;
/*    */     
/* 25 */     this.type = AbstractPower.PowerType.BUFF;
/* 26 */     this.isTurnBased = false;
/*    */     
/* 28 */     loadRegion("doubleTap");
/*    */     
/* 30 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
/* 35 */     if (source == this.owner && power instanceof TerrorPower) {
/* 36 */       flash();
/* 37 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, new EphemeralPower(this.owner, this.amount), this.amount));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 43 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/TerrifyingSpectrePower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */