/*    */ package Koishi.patches;
/*    */ 
/*    */ import Koishi.relics.EchoesOfADeadGirl;
/*    */ import Koishi.relics.TeethAndClaws;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.LineFinder;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.Matcher;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpireInsertLocator;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import javassist.CtBehavior;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SpirePatch(clz = ApplyPowerAction.class, method = "update")
/*    */ public class ApplyPowerRelicPatch
/*    */ {
/*    */   @SpireInsertPatch(locator = Locator.class, localvars = {"powerToApply"})
/*    */   public static void CheckPowers(ApplyPowerAction instance, AbstractPower powerToApply) {
/* 29 */     if (AbstractDungeon.player.hasRelic(TeethAndClaws.ID) && instance.source != null && instance.source.isPlayer && instance.target != instance.source && powerToApply.type == AbstractPower.PowerType.DEBUFF && !instance.target.hasPower("Artifact")) {
/* 30 */       AbstractDungeon.player.getRelic(TeethAndClaws.ID).onTrigger((AbstractCreature)AbstractDungeon.player);
/*    */     }
/* 32 */     if (AbstractDungeon.player.hasRelic(EchoesOfADeadGirl.ID) && instance.target != null && instance.target.isPlayer && (powerToApply instanceof com.megacrit.cardcrawl.powers.IntangiblePlayerPower || powerToApply instanceof com.megacrit.cardcrawl.powers.IntangiblePower))
/* 33 */       AbstractDungeon.player.getRelic(EchoesOfADeadGirl.ID).onTrigger((AbstractCreature)AbstractDungeon.player); 
/*    */   }
/*    */   
/*    */   private static class Locator
/*    */     extends SpireInsertLocator
/*    */   {
/*    */     public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
/* 40 */       Matcher.MethodCallMatcher methodCallMatcher = new Matcher.MethodCallMatcher(AbstractPlayer.class, "hasRelic");
/* 41 */       return LineFinder.findInOrder(ctMethodToPatch, (Matcher)methodCallMatcher);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/patches/ApplyPowerRelicPatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */