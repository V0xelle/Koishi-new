/*    */ package Koishi.variables;
/*    */ 
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import basemod.abstracts.DynamicVariable;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ 
/*    */ public class DefaultSecondMagicNumber
/*    */   extends DynamicVariable
/*    */ {
/*    */   public String key() {
/* 11 */     return "Koishi:SecondMagic";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isModified(AbstractCard card) {
/* 16 */     return ((AbstractDefaultCard)card).isDefaultSecondMagicNumberModified;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int value(AbstractCard card) {
/* 22 */     return ((AbstractDefaultCard)card).defaultSecondMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public int baseValue(AbstractCard card) {
/* 27 */     return ((AbstractDefaultCard)card).defaultBaseSecondMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean upgraded(AbstractCard card) {
/* 32 */     return ((AbstractDefaultCard)card).upgradedDefaultSecondMagicNumber;
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/variables/DefaultSecondMagicNumber.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */