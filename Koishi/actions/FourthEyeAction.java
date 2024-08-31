/*    */ package Koishi.actions;
/*    */ 
/*    */ import Koishi.powers.FourthEyePower;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ import com.megacrit.cardcrawl.relics.FrozenEye;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FourthEyeAction
/*    */   extends AbstractGameAction
/*    */ {
/*    */   public void update() {
/* 19 */     this.isDone = false;
/*    */     
/* 21 */     AbstractPlayer p = AbstractDungeon.player;
/*    */     
/* 23 */     for (AbstractRelic r : p.relics) {
/* 24 */       if (r.relicId.equals("Frozen Eye")) {
/* 25 */         this.isDone = true;
/*    */         
/*    */         return;
/*    */       } 
/*    */     } 
/* 30 */     FrozenEye frozenEye = new FrozenEye();
/* 31 */     AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new FourthEyePower((AbstractCreature)p, (AbstractRelic)frozenEye)));
/* 32 */     this.isDone = true;
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/actions/FourthEyeAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */