/*    */ package Koishi.actions;
/*    */ 
/*    */ import Koishi.cards.Skills.Rare.FadingMemory;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ExhaustAction;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
/*    */ 
/*    */ public class FadingMemoryAction
/*    */   extends AbstractGameAction {
/*    */   public FadingMemoryAction(FadingMemory card) {
/* 18 */     this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
/* 19 */     this.duration = Settings.ACTION_DUR_FAST;
/* 20 */     this.card = card;
/*    */   }
/*    */   FadingMemory card;
/*    */   public void update() {
/* 24 */     this.isDone = false;
/* 25 */     AbstractPlayer p = AbstractDungeon.player;
/*    */     
/* 27 */     AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new DrawCardNextTurnPower((AbstractCreature)p, this.card.defaultSecondMagicNumber), this.card.defaultSecondMagicNumber));
/* 28 */     AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ExhaustAction(this.card.magicNumber, false));
/* 29 */     if (p.hand.size() != 0) {
/* 30 */       AbstractDungeon.actionManager.addToTop((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.card.magicNumber));
/*    */     }
/*    */     
/* 33 */     this.isDone = true;
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/actions/FadingMemoryAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */