/*    */ package Koishi.cards.Skills.Rare;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ 
/*    */ public class RollingInRichesHeart
/*    */   extends AbstractDefaultCard
/*    */ {
/* 15 */   public static final String ID = KoishiMod.makeID(RollingInRichesHeart.class.getSimpleName());
/* 16 */   public static final String IMG = KoishiMod.makeCardPath("RollingInRichesHeart.png");
/*    */   
/* 18 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 19 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 20 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 21 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int GOLD_LOSS = 5;
/*    */   
/*    */   private static final int DAMAGE_BONUS = 3;
/*    */   private static final int UPGRADE_PLUS_DMG_BONUS = 2;
/*    */   
/*    */   public RollingInRichesHeart() {
/* 31 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 32 */     this.magicNumber = this.baseMagicNumber = 3;
/* 33 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 5;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 38 */     KoishiMod.runAnimation("rollingInRiches");
/* 39 */     AbstractDungeon.player.loseGold(this.defaultSecondMagicNumber);
/* 40 */     for (AbstractCard c : AbstractDungeon.player.hand.group) {
/* 41 */       if (c.type == AbstractCard.CardType.ATTACK) {
/* 42 */         c.baseDamage += this.magicNumber;
/* 43 */         c.applyPowers();
/* 44 */         c.flash();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 52 */     return 16.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 58 */     if (!this.upgraded) {
/* 59 */       upgradeName();
/* 60 */       upgradeMagicNumber(2);
/* 61 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Rare/RollingInRichesHeart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */