/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.SprinkleStarAndHeartAction;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class SprinkleStarAndHeart
/*    */   extends AbstractIdCard {
/* 15 */   public static final String ID = KoishiMod.makeID(SprinkleStarAndHeart.class.getSimpleName());
/* 16 */   public static final String IMG = KoishiMod.makeCardPath("SprinkleStarAndHeart.png");
/*    */   
/* 18 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 19 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ALL_ENEMY;
/* 20 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 21 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DEBUFF = 2;
/*    */   private static final int UPGRADE_PLUS_DEBUFF = 1;
/*    */   
/*    */   public SprinkleStarAndHeart() {
/* 29 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 30 */     this.magicNumber = this.baseMagicNumber = 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 35 */     KoishiMod.runAnimation("sprinkleStar");
/* 36 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new SprinkleStarAndHeartAction(this));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 42 */     return 16.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 48 */     if (!this.upgraded) {
/* 49 */       upgradeName();
/* 50 */       upgradeMagicNumber(1);
/* 51 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/SprinkleStarAndHeart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */