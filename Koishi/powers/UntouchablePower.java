/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class UntouchablePower
/*    */   extends AbstractPower
/*    */ {
/* 15 */   public static final String POWER_ID = KoishiMod.makeID("UntouchablePower");
/* 16 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 17 */   public static final String NAME = powerStrings.NAME;
/* 18 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public UntouchablePower(AbstractCreature owner, int amount) {
/* 21 */     this.name = NAME;
/* 22 */     this.ID = POWER_ID;
/*    */     
/* 24 */     this.owner = owner;
/* 25 */     this.amount = amount;
/*    */     
/* 27 */     this.type = AbstractPower.PowerType.BUFF;
/* 28 */     this.isTurnBased = false;
/*    */     
/* 30 */     loadRegion("noPain");
/*    */     
/* 32 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
/* 37 */     if (target == this.owner && (power instanceof com.megacrit.cardcrawl.powers.IntangiblePlayerPower || power instanceof com.megacrit.cardcrawl.powers.IntangiblePower)) {
/* 38 */       flash();
/* 39 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new AddTemporaryHPAction(this.owner, this.owner, this.amount));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 45 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/UntouchablePower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */