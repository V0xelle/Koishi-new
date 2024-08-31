/*    */ package Koishi.actions;
/*    */ 
/*    */ import Koishi.cards.Attacks.Uncommon.HeartAttack;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class HeartAttackAction extends AbstractGameAction {
/*    */   HeartAttack card;
/*    */   
/*    */   public HeartAttackAction(HeartAttack card) {
/* 17 */     this.actionType = AbstractGameAction.ActionType.DAMAGE;
/* 18 */     this.duration = Settings.ACTION_DUR_FAST;
/* 19 */     this.card = card;
/*    */   }
/*    */   
/*    */   public void update() {
/* 23 */     this.isDone = false;
/* 24 */     AbstractPlayer p = AbstractDungeon.player;
/*    */     
/* 26 */     AbstractMonster mo = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
/* 27 */     this.card.calculateCardDamage(mo);
/* 28 */     AbstractDungeon.actionManager.addToTop((AbstractGameAction)new DamageAction((AbstractCreature)mo, new DamageInfo((AbstractCreature)p, this.card.damage, this.card.damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE));
/*    */     
/* 30 */     this.isDone = true;
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/actions/HeartAttackAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */