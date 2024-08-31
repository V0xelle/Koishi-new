/*    */ package Koishi.patches;
/*    */ 
/*    */ import Koishi.powers.MindControlPower;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.ByRef;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.LineFinder;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.Matcher;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpireInsertLocator;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.unique.VampireDamageAction;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import java.util.ArrayList;
/*    */ import javassist.CtBehavior;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SpirePatch(clz = DamageAction.class, method = "update")
/*    */ public class MindControlRetargetPatch
/*    */ {
/*    */   @SpireInsertPatch(locator = Locator.class, localvars = {"info"})
/*    */   public static void ChangeTarget(DamageAction instance, @ByRef DamageInfo[] info) {
/* 27 */     if (instance.source != null && 
/* 28 */       instance.source.hasPower(MindControlPower.POWER_ID)) {
/* 29 */       instance.target = (AbstractCreature)AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
/* 30 */       if (instance.target != null)
/* 31 */         info[0].applyPowers(instance.source, instance.target); 
/*    */     } 
/*    */   }
/*    */   
/*    */   private static class Locator
/*    */     extends SpireInsertLocator
/*    */   {
/*    */     public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
/* 39 */       Matcher.MethodCallMatcher methodCallMatcher = new Matcher.MethodCallMatcher(ArrayList.class, "add");
/* 40 */       return LineFinder.findInOrder(ctMethodToPatch, (Matcher)methodCallMatcher);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SpirePatch(clz = VampireDamageAction.class, method = "update")
/*    */   public static class VampireDamageActionRetarget
/*    */   {
/*    */     @SpireInsertPatch(locator = Locator.class, localvars = {"info"})
/*    */     public static void ChangeTarget(VampireDamageAction instance, @ByRef DamageInfo[] info) {
/* 52 */       if (instance.source != null && 
/* 53 */         instance.source.hasPower(MindControlPower.POWER_ID)) {
/* 54 */         instance.target = (AbstractCreature)AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
/* 55 */         if (instance.target != null)
/* 56 */           info[0].applyPowers(instance.source, instance.target); 
/*    */       } 
/*    */     }
/*    */     
/*    */     private static class Locator
/*    */       extends SpireInsertLocator
/*    */     {
/*    */       public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
/* 64 */         Matcher.MethodCallMatcher methodCallMatcher = new Matcher.MethodCallMatcher(ArrayList.class, "add");
/* 65 */         return LineFinder.findInOrder(ctMethodToPatch, (Matcher)methodCallMatcher);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/patches/MindControlRetargetPatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */