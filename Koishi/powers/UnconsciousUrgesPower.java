/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.UnconsciousUrgesAction;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class UnconsciousUrgesPower extends AbstractPower {
/* 16 */   public static final String POWER_ID = KoishiMod.makeID("UnconsciousUrgesPower");
/* 17 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 18 */   public static final String NAME = powerStrings.NAME;
/* 19 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public AbstractCard chosenCard;
/*    */   public boolean triggered = false;
/*    */   
/*    */   public UnconsciousUrgesPower(AbstractCreature owner, int amount) {
/* 25 */     this.name = NAME;
/* 26 */     this.ID = POWER_ID;
/*    */     
/* 28 */     this.owner = owner;
/* 29 */     this.amount = amount;
/*    */     
/* 31 */     this.type = AbstractPower.PowerType.BUFF;
/* 32 */     this.isTurnBased = false;
/*    */     
/* 34 */     loadRegion("corruption");
/*    */     
/* 36 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void atStartOfTurnPostDraw() {
/* 41 */     flash();
/* 42 */     this.triggered = false;
/* 43 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new UnconsciousUrgesAction(this));
/*    */   }
/*    */ 
/*    */   
/*    */   public void onAfterCardPlayed(AbstractCard card) {
/* 48 */     if (!this.triggered && this.chosenCard != null && card.cardID.equals(this.chosenCard.cardID)) {
/* 49 */       flash();
/* 50 */       this.triggered = true;
/* 51 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, new EnergyNextTurnPower(this.owner, this.amount), this.amount));
/* 52 */       updateDescription();
/* 53 */       for (AbstractCard c : AbstractDungeon.player.hand.group) {
/* 54 */         if (c.cardID.equals(this.chosenCard.cardID)) {
/* 55 */           c.glowColor = new Color(0.2F, 0.9F, 1.0F, 0.25F);
/* 56 */           c.triggerOnGlowCheck();
/*    */         }
/*    */       
/*    */       } 
/* 60 */     } else if (!this.triggered && this.chosenCard != null) {
/* 61 */       this.chosenCard.glowColor = new Color(0.0F, 0.85F, 0.0F, 1.0F);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
/* 68 */     super.onApplyPower(power, target, source);
/* 69 */     if (!this.triggered && this.chosenCard != null) {
/* 70 */       this.chosenCard.glowColor = new Color(0.0F, 0.85F, 0.0F, 1.0F);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 76 */     if (this.triggered || this.chosenCard == null) {
/* 77 */       this.description = DESCRIPTIONS[0];
/* 78 */       for (int i = 0; i < this.amount; i++) {
/* 79 */         this.description += " [E]";
/*    */       }
/* 81 */       this.description += DESCRIPTIONS[1];
/*    */     } else {
/* 83 */       this.description = DESCRIPTIONS[2] + this.chosenCard.name + DESCRIPTIONS[3];
/* 84 */       for (int i = 0; i < this.amount; i++) {
/* 85 */         this.description += " [E]";
/*    */       }
/* 87 */       this.description += DESCRIPTIONS[1];
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/UnconsciousUrgesPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */