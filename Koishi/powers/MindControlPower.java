/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.actions.common.HealAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MindControlPower
/*    */   extends AbstractPower
/*    */ {
/*    */   public AbstractCreature source;
/* 22 */   public static final String POWER_ID = KoishiMod.makeID("MindControlPower");
/* 23 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 24 */   public static final String NAME = powerStrings.NAME;
/* 25 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public MindControlPower(AbstractCreature owner, AbstractCreature source, int amount) {
/* 28 */     this.name = NAME;
/* 29 */     this.ID = POWER_ID;
/*    */     
/* 31 */     this.owner = owner;
/* 32 */     this.amount = amount;
/* 33 */     this.source = source;
/*    */     
/* 35 */     this.type = AbstractPower.PowerType.DEBUFF;
/* 36 */     this.isTurnBased = true;
/*    */     
/* 38 */     loadRegion("confusion");
/*    */     
/* 40 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
/* 45 */     if (source == this.owner && power.type == AbstractPower.PowerType.BUFF) {
/* 46 */       power.owner = this.source;
/* 47 */       AbstractDungeon.actionManager.currentAction.target = this.source;
/* 48 */       if (power instanceof com.megacrit.cardcrawl.powers.SharpHidePower || power instanceof com.megacrit.cardcrawl.powers.BeatOfDeathPower || power instanceof com.megacrit.cardcrawl.powers.StasisPower) {
/* 49 */         if (power instanceof com.megacrit.cardcrawl.powers.StasisPower) {
/* 50 */           power.onDeath();
/*    */         }
/* 52 */         AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction(this.source, this.source, power.ID));
/*    */       }
/*    */     
/* 55 */     } else if (source == this.owner && power.type == AbstractPower.PowerType.DEBUFF) {
/* 56 */       AbstractMonster newTarget = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
/* 57 */       power.owner = (AbstractCreature)newTarget;
/* 58 */       AbstractDungeon.actionManager.currentAction.target = (AbstractCreature)newTarget;
/* 59 */       if (power instanceof com.megacrit.cardcrawl.powers.HexPower) {
/* 60 */         AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction((AbstractCreature)newTarget, (AbstractCreature)newTarget, power.ID));
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public int onBlock(float blockAmount) {
/* 66 */     AbstractDungeon.actionManager.addToTop((AbstractGameAction)new GainBlockAction(this.source, this.source, (int)blockAmount));
/* 67 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int onHeal(int healAmount) {
/* 72 */     AbstractDungeon.actionManager.addToTop((AbstractGameAction)new HealAction(this.source, this.source, healAmount));
/* 73 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void atEndOfRound() {
/* 78 */     if (this.amount == 0) {
/* 79 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));
/*    */     } else {
/* 81 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this.ID, 1));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 87 */     if (this.amount == 1) {
/* 88 */       this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */     } else {
/* 90 */       this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[2];
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/MindControlPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */