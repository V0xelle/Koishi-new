/*    */ package Koishi.actions;
/*    */ 
/*    */ import Koishi.powers.UnconsciousUrgesPower;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class UnconsciousUrgesAction
/*    */   extends AbstractGameAction {
/*    */   private UnconsciousUrgesPower power;
/*    */   
/*    */   public UnconsciousUrgesAction(UnconsciousUrgesPower owner) {
/* 16 */     this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
/* 17 */     this.duration = Settings.ACTION_DUR_FAST;
/* 18 */     this.power = owner;
/*    */   }
/*    */   
/*    */   public void update() {
/* 22 */     this.isDone = false;
/*    */     
/* 24 */     ArrayList<AbstractCard> hand = new ArrayList<>();
/* 25 */     for (AbstractCard card : AbstractDungeon.player.hand.group) {
/* 26 */       if (card.type != AbstractCard.CardType.STATUS && card.type != AbstractCard.CardType.CURSE) {
/* 27 */         hand.add(card);
/*    */       }
/*    */     } 
/* 30 */     if (hand.size() > 0) {
/* 31 */       this.power.chosenCard = hand.get(AbstractDungeon.cardRandomRng.random(hand.size() - 1));
/*    */       
/* 33 */       for (AbstractCard card : AbstractDungeon.player.hand.group) {
/* 34 */         if (card.cardID.equals(this.power.chosenCard.cardID)) {
/* 35 */           card.flash();
/* 36 */           card.glowColor = new Color(0.0F, 0.85F, 0.0F, 1.0F);
/*    */         } 
/*    */       } 
/*    */     } else {
/*    */       
/* 41 */       this.power.chosenCard = null;
/*    */     } 
/* 43 */     this.power.updateDescription();
/*    */     
/* 45 */     this.isDone = true;
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/actions/UnconsciousUrgesAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */