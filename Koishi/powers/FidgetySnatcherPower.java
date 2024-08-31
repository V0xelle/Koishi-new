/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.ConstrictedPower;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class FidgetySnatcherPower
/*    */   extends AbstractPower {
/* 17 */   public static final String POWER_ID = KoishiMod.makeID("FidgetySnatcherPower");
/* 18 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 19 */   public static final String NAME = powerStrings.NAME;
/* 20 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public FidgetySnatcherPower(AbstractCreature owner, int amount) {
/* 23 */     this.name = NAME;
/* 24 */     this.ID = POWER_ID;
/*    */     
/* 26 */     this.owner = owner;
/* 27 */     this.amount = amount;
/*    */     
/* 29 */     this.type = AbstractPower.PowerType.BUFF;
/* 30 */     this.isTurnBased = false;
/*    */     
/* 32 */     loadRegion("evolve");
/*    */     
/* 34 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void atStartOfTurnPostDraw() {
/* 39 */     if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
/* 40 */       flash();
/* 41 */       Iterator<AbstractMonster> iterator = (AbstractDungeon.getMonsters()).monsters.iterator();
/*    */       
/* 43 */       while (iterator.hasNext()) {
/* 44 */         AbstractMonster m = iterator.next();
/* 45 */         if (!m.isDead && !m.isDying) {
/* 46 */           AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, this.owner, (AbstractPower)new ConstrictedPower((AbstractCreature)m, this.owner, this.amount), this.amount));
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 54 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/FidgetySnatcherPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */