/*    */ package Koishi.patches;
/*    */ 
/*    */ import Koishi.powers.MindControlPower;
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.ByRef;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.LineFinder;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.Matcher;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpireInsertLocator;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import java.util.Iterator;
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
/*    */ @SpirePatch(clz = AbstractCreature.class, method = "addBlock", paramtypez = {int.class})
/*    */ public class onGainedBlockPatch
/*    */ {
/*    */   @SpireInsertPatch(locator = Locator.class, localvars = {"tmp"})
/*    */   public static void TriggerOnGainedBlock(AbstractCreature instance, int blockAmount, @ByRef float[] tmp) {
/* 29 */     if (!instance.isPlayer && 
/* 30 */       tmp[0] > 0.0F) {
/* 31 */       Iterator<AbstractPower> iterator = instance.powers.iterator();
/* 32 */       while (iterator.hasNext()) {
/* 33 */         AbstractPower p = iterator.next();
/* 34 */         if (p instanceof MindControlPower)
/* 35 */           tmp[0] = ((MindControlPower)p).onBlock(blockAmount); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private static class Locator
/*    */     extends SpireInsertLocator
/*    */   {
/*    */     public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
/* 44 */       Matcher.MethodCallMatcher methodCallMatcher = new Matcher.MethodCallMatcher(MathUtils.class, "floor");
/* 45 */       return LineFinder.findInOrder(ctMethodToPatch, (Matcher)methodCallMatcher);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/patches/onGainedBlockPatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */