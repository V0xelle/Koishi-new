/*    */ package Koishi.actions;
/*    */ 
/*    */ import basemod.ReflectionHacks;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.animations.VFXAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
/*    */ import com.megacrit.cardcrawl.vfx.combat.OfferingEffect;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MassHysteriaAction
/*    */   extends AbstractGameAction
/*    */ {
/*    */   public void update() {
/* 23 */     this.isDone = false;
/*    */     
/* 25 */     int totalDamage = 0;
/* 26 */     Iterator<AbstractMonster> iterator = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 27 */     while (iterator.hasNext()) {
/* 28 */       AbstractMonster mo = iterator.next();
/* 29 */       if (!mo.isDeadOrEscaped()) {
/* 30 */         mo.createIntent();
/* 31 */         if (ForceIntentAction.attackTest.test(mo)) {
/* 32 */           int moDamage = ((Integer)ReflectionHacks.getPrivate(mo, AbstractMonster.class, "intentDmg")).intValue();
/* 33 */           if (((Boolean)ReflectionHacks.getPrivate(mo, AbstractMonster.class, "isMultiDmg")).booleanValue()) {
/* 34 */             moDamage *= ((Integer)ReflectionHacks.getPrivate(mo, AbstractMonster.class, "intentMultiAmt")).intValue();
/*    */           }
/* 36 */           totalDamage += moDamage;
/*    */         } 
/*    */       } 
/*    */     } 
/* 40 */     if (totalDamage > 0) {
/* 41 */       int[] newMultiDamage = new int[(AbstractDungeon.getCurrRoom()).monsters.monsters.size()];
/* 42 */       for (int i = 0; i < newMultiDamage.length; i++) {
/* 43 */         newMultiDamage[i] = totalDamage;
/*    */       }
/* 45 */       if (Settings.FAST_MODE) {
/* 46 */         AbstractDungeon.actionManager.addToTop((AbstractGameAction)new VFXAction((AbstractGameEffect)new OfferingEffect(), 0.1F));
/*    */       } else {
/* 48 */         AbstractDungeon.actionManager.addToTop((AbstractGameAction)new VFXAction((AbstractGameEffect)new OfferingEffect(), 0.5F));
/*    */       } 
/* 50 */       AbstractDungeon.actionManager.addToTop((AbstractGameAction)new DamageAllEnemiesAction((AbstractCreature)AbstractDungeon.player, newMultiDamage, DamageInfo.DamageType.HP_LOSS, AbstractGameAction.AttackEffect.NONE));
/*    */     } 
/*    */     
/* 53 */     this.isDone = true;
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/actions/MassHysteriaAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */