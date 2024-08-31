/*    */ package Koishi.actions;
/*    */ 
/*    */ import Koishi.cards.AbstractIntentChangingCard;
/*    */ import basemod.ReflectionHacks;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.monsters.EnemyMoveInfo;
/*    */ import java.util.function.Predicate;
/*    */ 
/*    */ public class ForceIntentAction extends AbstractGameAction {
/*    */   private AbstractIntentChangingCard.IntentTypes intentType;
/*    */   public static Predicate<AbstractMonster> attackTest;
/*    */   public static Predicate<AbstractMonster> notAttackTest;
/*    */   private AbstractPlayer p;
/*    */   private AbstractMonster m;
/*    */   
/*    */   static {
/* 19 */     attackTest = (mo -> (mo.getIntentBaseDmg() >= 0));
/* 20 */     notAttackTest = (mo -> (mo.getIntentBaseDmg() < 0));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ForceIntentAction(AbstractPlayer p, AbstractMonster m, AbstractIntentChangingCard.IntentTypes type) {
/* 26 */     this.p = p;
/* 27 */     this.m = m;
/* 28 */     this.intentType = type;
/*    */   }
/*    */   
/*    */   public void update() {
/* 32 */     this.isDone = newIntent(this.m, this.intentType);
/*    */   }
/*    */   
/*    */   public boolean newIntent(AbstractMonster m, AbstractIntentChangingCard.IntentTypes type) {
/*    */     Predicate<AbstractMonster> test;
/* 37 */     if (m.id.equals("GiantHead") || m.id.equals("Maw") || m.id.equals("BookOfStabbing") || m.id.equals("CorruptHeart")) {
/* 38 */       return true;
/*    */     }
/*    */ 
/*    */     
/* 42 */     if (type == AbstractIntentChangingCard.IntentTypes.ATTACK) {
/* 43 */       test = attackTest;
/*    */     } else {
/* 45 */       test = notAttackTest;
/*    */     } 
/*    */     
/* 48 */     if (test.test(m)) {
/* 49 */       return true;
/*    */     }
/*    */     
/* 52 */     EnemyMoveInfo originalMove = (EnemyMoveInfo)ReflectionHacks.getPrivate(m, AbstractMonster.class, "move");
/* 53 */     int tries = 0;
/* 54 */     while (tries < 10) {
/* 55 */       m.rollMove();
/* 56 */       m.createIntent();
/* 57 */       if (test.test(m)) {
/* 58 */         return true;
/*    */       }
/* 60 */       tries++;
/*    */     } 
/*    */     
/* 63 */     m.setMove(originalMove.nextMove, originalMove.intent, originalMove.baseDamage, originalMove.multiplier, originalMove.isMultiDamage);
/* 64 */     m.createIntent();
/* 65 */     return true;
/*    */   }
/*    */   
/*    */   public static boolean previewNewIntent(AbstractMonster m, AbstractIntentChangingCard.IntentTypes type) {
/*    */     Predicate<AbstractMonster> test;
/* 70 */     if (m.id.equals("GiantHead") || m.id.equals("Maw") || m.id.equals("BookOfStabbing") || m.id.equals("CorruptHeart")) {
/* 71 */       return true;
/*    */     }
/*    */ 
/*    */     
/* 75 */     if (type == AbstractIntentChangingCard.IntentTypes.ATTACK) {
/* 76 */       test = attackTest;
/*    */     } else {
/* 78 */       test = notAttackTest;
/*    */     } 
/*    */     
/* 81 */     if (test.test(m)) {
/* 82 */       return true;
/*    */     }
/*    */     
/* 85 */     EnemyMoveInfo originalMove = (EnemyMoveInfo)ReflectionHacks.getPrivate(m, AbstractMonster.class, "move");
/* 86 */     int tries = 0;
/* 87 */     while (tries < 10) {
/* 88 */       m.rollMove();
/* 89 */       m.createIntent();
/* 90 */       if (test.test(m)) {
/* 91 */         return true;
/*    */       }
/* 93 */       tries++;
/*    */     } 
/*    */     
/* 96 */     m.setMove(originalMove.nextMove, originalMove.intent, originalMove.baseDamage, originalMove.multiplier, originalMove.isMultiDamage);
/* 97 */     m.createIntent();
/* 98 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/actions/ForceIntentAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */