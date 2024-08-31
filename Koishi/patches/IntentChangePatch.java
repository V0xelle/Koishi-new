/*    */ package Koishi.patches;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SpirePatch(clz = AbstractPlayer.class, method = "renderHand", paramtypez = {SpriteBatch.class})
/*    */ public class IntentChangePatch
/*    */ {
/*    */   @SpirePrefixPatch
/*    */   public static void FixCalculateCardDamage(AbstractPlayer instance) {
/* 21 */     AbstractCard hoveredCard = instance.hoveredCard;
/* 22 */     if (hoveredCard != null && instance.isDraggingCard && !instance.inSingleTargetMode && 
/* 23 */       hoveredCard instanceof Koishi.cards.AbstractIntentChangingCard && hoveredCard.target == AbstractCard.CardTarget.ALL_ENEMY)
/* 24 */       hoveredCard.calculateCardDamage(null); 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/patches/IntentChangePatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */