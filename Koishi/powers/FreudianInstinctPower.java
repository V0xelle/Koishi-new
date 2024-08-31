/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class FreudianInstinctPower
/*    */   extends AbstractPower {
/* 15 */   public static final String POWER_ID = KoishiMod.makeID("FreudianInstinctPower");
/* 16 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 17 */   public static final String NAME = powerStrings.NAME;
/* 18 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public FreudianInstinctPower(AbstractCreature owner, int amount) {
/* 21 */     this.name = NAME;
/* 22 */     this.ID = POWER_ID;
/*    */     
/* 24 */     this.owner = owner;
/* 25 */     this.amount = amount;
/*    */     
/* 27 */     this.type = AbstractPower.PowerType.BUFF;
/* 28 */     this.isTurnBased = false;
/*    */     
/* 30 */     loadRegion("afterImage");
/*    */     
/* 32 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCardDraw(AbstractCard card) {
/* 37 */     if (card instanceof Koishi.cards.AbstractIdCard) {
/* 38 */       flash();
/* 39 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction(this.owner, this.owner, this.amount));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 45 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/FreudianInstinctPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */