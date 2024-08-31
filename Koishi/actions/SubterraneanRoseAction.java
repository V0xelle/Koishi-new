/*    */ package Koishi.actions;
/*    */ 
/*    */ import Koishi.cards.Skills.Common.SubterraneanRose;
/*    */ import Koishi.powers.LoseThornsPower;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.ThornsPower;
/*    */ 
/*    */ public class SubterraneanRoseAction
/*    */   extends AbstractGameAction {
/*    */   public SubterraneanRoseAction(SubterraneanRose card) {
/* 18 */     this.actionType = AbstractGameAction.ActionType.BLOCK;
/* 19 */     this.duration = Settings.ACTION_DUR_FAST;
/* 20 */     this.card = card;
/*    */   }
/*    */   SubterraneanRose card;
/*    */   public void update() {
/* 24 */     this.isDone = false;
/*    */     
/* 26 */     AbstractPlayer p = AbstractDungeon.player;
/* 27 */     this.card.calculateCardDamage(null);
/* 28 */     AbstractDungeon.actionManager.addToTop((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.card.block));
/* 29 */     AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new ThornsPower((AbstractCreature)p, this.card.magicNumber), this.card.magicNumber));
/* 30 */     AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new LoseThornsPower((AbstractCreature)p, this.card.magicNumber), this.card.magicNumber));
/*    */     
/* 32 */     this.isDone = true;
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/actions/SubterraneanRoseAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */