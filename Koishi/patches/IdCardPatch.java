/*    */ package Koishi.patches;
/*    */ 
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.LineFinder;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.Matcher;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpireInsertLocator;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.CardGroup;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import javassist.CtBehavior;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SpirePatch(clz = AbstractPlayer.class, method = "draw", paramtypez = {int.class})
/*    */ public class IdCardPatch
/*    */ {
/*    */   @SpireInsertPatch(locator = Locator.class, localvars = {"c"})
/*    */   public static void FixDiscardPatch(AbstractPlayer instance, int drawAmount, AbstractCard c) {
/* 27 */     if (c instanceof AbstractIdCard && AbstractIdCard.idEnabled)
/* 28 */       instance.hand.removeCard(c); 
/*    */   }
/*    */   
/*    */   private static class Locator
/*    */     extends SpireInsertLocator
/*    */   {
/*    */     public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
/* 35 */       Matcher.MethodCallMatcher methodCallMatcher = new Matcher.MethodCallMatcher(CardGroup.class, "removeTopCard");
/* 36 */       return LineFinder.findInOrder(ctMethodToPatch, (Matcher)methodCallMatcher);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/patches/IdCardPatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */