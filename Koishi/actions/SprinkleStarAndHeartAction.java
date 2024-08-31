/*    */ package Koishi.actions;
/*    */ 
/*    */ import Koishi.cards.Skills.Uncommon.SprinkleStarAndHeart;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.VulnerablePower;
/*    */ import com.megacrit.cardcrawl.powers.WeakPower;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class SprinkleStarAndHeartAction extends AbstractGameAction {
/*    */   SprinkleStarAndHeart card;
/*    */   
/*    */   public SprinkleStarAndHeartAction(SprinkleStarAndHeart card) {
/* 20 */     this.actionType = AbstractGameAction.ActionType.DEBUFF;
/* 21 */     this.duration = Settings.ACTION_DUR_FAST;
/* 22 */     this.card = card;
/*    */   }
/*    */   
/*    */   public void update() {
/* 26 */     this.isDone = false;
/* 27 */     AbstractPlayer p = AbstractDungeon.player;
/*    */     
/* 29 */     Iterator<AbstractMonster> iterator = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 30 */     while (iterator.hasNext()) {
/* 31 */       AbstractMonster mo = iterator.next();
/* 32 */       AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)mo, this.card.magicNumber, false), this.card.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
/* 33 */       AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)mo, this.card.magicNumber, false), this.card.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
/*    */     } 
/*    */     
/* 36 */     this.isDone = true;
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/actions/SprinkleStarAndHeartAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */