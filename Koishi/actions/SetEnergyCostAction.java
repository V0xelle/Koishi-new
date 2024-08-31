/*    */ package Koishi.actions;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
/*    */ 
/*    */ public class SetEnergyCostAction
/*    */   extends AbstractGameAction {
/*    */   AbstractCard card;
/*    */   
/*    */   public SetEnergyCostAction(AbstractCard card) {
/* 13 */     this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
/* 14 */     this.duration = Settings.ACTION_DUR_FAST;
/* 15 */     this.card = card;
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {
/* 20 */     if (EnergyPanel.getCurrentEnergy() < this.card.costForTurn) {
/* 21 */       System.out.println("costForTurn: " + this.card.costForTurn);
/* 22 */       System.out.println("energy: " + EnergyPanel.getCurrentEnergy());
/* 23 */       this.card.setCostForTurn(EnergyPanel.getCurrentEnergy());
/* 24 */       System.out.println("costForTurnAfter: " + this.card.costForTurn);
/*    */     } 
/* 26 */     this.isDone = true;
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/actions/SetEnergyCostAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */