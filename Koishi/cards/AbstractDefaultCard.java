/*    */ package Koishi.cards;
/*    */ 
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractDefaultCard
/*    */   extends CustomCard
/*    */ {
/*    */   public int defaultSecondMagicNumber;
/*    */   public int defaultBaseSecondMagicNumber;
/*    */   public boolean upgradedDefaultSecondMagicNumber;
/*    */   public boolean isDefaultSecondMagicNumberModified;
/*    */   
/*    */   public AbstractDefaultCard(String id, String img, int cost, AbstractCard.CardType type, AbstractCard.CardColor color, AbstractCard.CardRarity rarity, AbstractCard.CardTarget target) {
/* 30 */     super(id, (CardCrawlGame.languagePack.getCardStrings(id)).NAME, img, cost, (CardCrawlGame.languagePack.getCardStrings(id)).DESCRIPTION, type, color, rarity, target);
/*    */ 
/*    */     
/* 33 */     this.isCostModified = false;
/* 34 */     this.isCostModifiedForTurn = false;
/* 35 */     this.isDamageModified = false;
/* 36 */     this.isBlockModified = false;
/* 37 */     this.isMagicNumberModified = false;
/* 38 */     this.isDefaultSecondMagicNumberModified = false;
/*    */   }
/*    */   
/*    */   public void displayUpgrades() {
/* 42 */     super.displayUpgrades();
/* 43 */     if (this.upgradedDefaultSecondMagicNumber) {
/* 44 */       this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber;
/* 45 */       this.isDefaultSecondMagicNumberModified = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgradeDefaultSecondMagicNumber(int amount) {
/* 51 */     this.defaultBaseSecondMagicNumber += amount;
/* 52 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber;
/* 53 */     this.upgradedDefaultSecondMagicNumber = true;
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/AbstractDefaultCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */