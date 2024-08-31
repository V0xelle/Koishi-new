/*    */ package Koishi.actions;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.helpers.GetAllInBattleInstances;
/*    */ import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
/*    */ import java.util.Iterator;
/*    */ import java.util.UUID;
/*    */ 
/*    */ public class SilentAndRestlessAction
/*    */   extends AbstractGameAction
/*    */ {
/*    */   private int increaseAmount;
/*    */   private DamageInfo info;
/*    */   private UUID uuid;
/*    */   
/*    */   public SilentAndRestlessAction(AbstractCreature target, DamageInfo info, int incAmount, UUID targetUUID) {
/* 21 */     this.info = info;
/* 22 */     setValues(target, info);
/* 23 */     this.increaseAmount = incAmount;
/* 24 */     this.actionType = AbstractGameAction.ActionType.DAMAGE;
/* 25 */     this.duration = 0.1F;
/* 26 */     this.uuid = targetUUID;
/*    */   }
/*    */   
/*    */   public void update() {
/* 30 */     if (this.duration == 0.1F && this.target != null) {
/* 31 */       AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/* 32 */       this.target.damage(this.info);
/* 33 */       if ((this.target.isDying || this.target.currentHealth <= 0) && !this.target.halfDead && !this.target.hasPower("Minion")) {
/* 34 */         Iterator<AbstractCard> var1 = AbstractDungeon.player.masterDeck.group.iterator();
/*    */ 
/*    */         
/* 37 */         while (var1.hasNext()) {
/* 38 */           AbstractCard c = var1.next();
/* 39 */           if (c.uuid.equals(this.uuid)) {
/* 40 */             c.misc += this.increaseAmount;
/* 41 */             c.applyPowers();
/* 42 */             c.magicNumber = c.baseMagicNumber = c.misc;
/* 43 */             c.isMagicNumberModified = false;
/*    */           } 
/*    */         } 
/*    */         
/* 47 */         for (var1 = GetAllInBattleInstances.get(this.uuid).iterator(); var1.hasNext(); c.magicNumber = c.baseMagicNumber = c.misc) {
/* 48 */           AbstractCard c = var1.next();
/* 49 */           c.misc += this.increaseAmount;
/* 50 */           c.applyPowers();
/*    */         } 
/*    */       } 
/*    */       
/* 54 */       if ((AbstractDungeon.getCurrRoom()).monsters.areMonstersBasicallyDead()) {
/* 55 */         AbstractDungeon.actionManager.clearPostCombatActions();
/*    */       }
/*    */     } 
/*    */     
/* 59 */     tickDuration();
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/actions/SilentAndRestlessAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */