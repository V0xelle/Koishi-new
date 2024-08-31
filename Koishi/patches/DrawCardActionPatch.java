/*    */ package Koishi.patches;
/*    */ 
/*    */ import basemod.ReflectionHacks;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SpirePatch(clz = DrawCardAction.class, method = "update")
/*    */ public class DrawCardActionPatch
/*    */ {
/*    */   @SpirePrefixPatch
/*    */   public static void DrawOneAtATime(DrawCardAction instance) {
/* 20 */     if (instance.amount > 1 && AbstractDungeon.player instanceof Koishi.characters.KoishiCharacter) {
/* 21 */       AbstractGameAction followUp = (AbstractGameAction)ReflectionHacks.getPrivate(instance, DrawCardAction.class, "followUpAction");
/* 22 */       if (followUp == null) {
/* 23 */         int remainder = instance.amount - 1;
/* 24 */         instance.amount = 1;
/* 25 */         for (int i = 0; i < remainder; i++)
/* 26 */           AbstractDungeon.actionManager.addToTop((AbstractGameAction)new DrawCardAction((AbstractCreature)AbstractDungeon.player, 1)); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/patches/DrawCardActionPatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */