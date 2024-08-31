/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
/*    */ 
/*    */ public class FormlessExistencePower
/*    */   extends AbstractPower
/*    */ {
/* 16 */   public static final String POWER_ID = KoishiMod.makeID("FormlessExistencePower");
/* 17 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 18 */   public static final String NAME = powerStrings.NAME;
/* 19 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   private boolean active = true;
/*    */   
/*    */   public FormlessExistencePower(AbstractCreature owner, int amount) {
/* 24 */     this.name = NAME;
/* 25 */     this.ID = POWER_ID;
/*    */     
/* 27 */     this.owner = owner;
/* 28 */     this.amount = amount;
/*    */     
/* 30 */     this.type = AbstractPower.PowerType.BUFF;
/* 31 */     this.isTurnBased = false;
/*    */     
/* 33 */     loadRegion("blur");
/*    */     
/* 35 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
/* 40 */     if (target == this.owner && (power instanceof IntangiblePlayerPower || power instanceof com.megacrit.cardcrawl.powers.IntangiblePower) && 
/* 41 */       this.active) {
/* 42 */       this.active = false;
/* 43 */       addToTop(new AbstractGameAction()
/*    */           {
/*    */             public void update() {
/* 46 */               this.isDone = true;
/* 47 */               FormlessExistencePower.this.active = true;
/*    */             }
/*    */           });
/* 50 */       flash();
/* 51 */       int bonusAmount = power.amount * this.amount;
/* 52 */       AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, (AbstractPower)new IntangiblePlayerPower(this.owner, bonusAmount), bonusAmount));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int onHeal(int healAmount) {
/* 59 */     flash();
/* 60 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 65 */     this.description = DESCRIPTIONS[0] + (this.amount + 1) + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/FormlessExistencePower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */