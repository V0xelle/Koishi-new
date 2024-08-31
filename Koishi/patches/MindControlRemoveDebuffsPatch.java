/*    */ package Koishi.patches;
/*    */ 
/*    */ import Koishi.powers.MindControlPower;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.ByRef;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.LineFinder;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.Matcher;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpireInsertLocator;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
/*    */ import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import java.util.ArrayList;
/*    */ import javassist.CtBehavior;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SpirePatch(clz = RemoveDebuffsAction.class, method = "update")
/*    */ public class MindControlRemoveDebuffsPatch
/*    */ {
/*    */   @SpireInsertPatch(locator = Locator.class, localvars = {"c"})
/*    */   public static void ChangeTarget(RemoveDebuffsAction instance, @ByRef AbstractCreature[] c) {
/* 26 */     if (c[0].hasPower(MindControlPower.POWER_ID))
/* 27 */       c[0] = (AbstractCreature)AbstractDungeon.player; 
/*    */   }
/*    */   
/*    */   private static class Locator
/*    */     extends SpireInsertLocator {
/*    */     public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
/* 33 */       Matcher.MethodCallMatcher methodCallMatcher = new Matcher.MethodCallMatcher(ArrayList.class, "iterator");
/* 34 */       return LineFinder.findInOrder(ctMethodToPatch, (Matcher)methodCallMatcher);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/patches/MindControlRemoveDebuffsPatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */