/*    */ package Koishi.actions;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ 
/*    */ public class PlayIdCardAction extends AbstractGameAction {
/*    */   private boolean exhaustCards;
/*    */   private AbstractCard card;
/*    */   
/*    */   public PlayIdCardAction(AbstractCard card, AbstractCreature target, boolean exhausts) {
/* 15 */     this.duration = Settings.ACTION_DUR_FAST;
/* 16 */     this.actionType = AbstractGameAction.ActionType.WAIT;
/* 17 */     this.source = (AbstractCreature)AbstractDungeon.player;
/* 18 */     this.target = target;
/* 19 */     this.exhaustCards = exhausts;
/* 20 */     this.card = card;
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {
/* 25 */     this.card.exhaustOnUseOnce = this.exhaustCards;
/* 26 */     this.card.applyPowers();
/* 27 */     addToTop((AbstractGameAction)new NewQueueCardAction(this.card, this.target, false, true));
/*    */     
/* 29 */     this.isDone = true;
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/actions/PlayIdCardAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */