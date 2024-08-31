/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.actions.unique.DiscardPileToTopOfDeckAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class GeneticsOfTheUnconscious
/*    */   extends AbstractDefaultCard {
/* 18 */   public static final String ID = KoishiMod.makeID(GeneticsOfTheUnconscious.class.getSimpleName());
/* 19 */   public static final String IMG = KoishiMod.makeCardPath("GeneticsOfTheUnconscious.png");
/*    */   
/* 21 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 22 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 23 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 24 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int DRAW = 1;
/*    */   
/*    */   private static final int UPGRADE_DRAW = 1;
/*    */   private static final int EFFECT = 1;
/*    */   private static final int UPGRADE_EFFECT = 1;
/*    */   
/*    */   public GeneticsOfTheUnconscious() {
/* 35 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 36 */     this.magicNumber = this.baseMagicNumber = 1;
/* 37 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 1;
/* 38 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 43 */     KoishiMod.runAnimation("spellCall");
/* 44 */     for (int i = 0; i < this.defaultSecondMagicNumber; i++) {
/* 45 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DiscardPileToTopOfDeckAction((AbstractCreature)p));
/*    */     }
/* 47 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 53 */     return 12.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 59 */     if (!this.upgraded) {
/* 60 */       upgradeName();
/* 61 */       upgradeMagicNumber(1);
/* 62 */       upgradeDefaultSecondMagicNumber(1);
/* 63 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 64 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/GeneticsOfTheUnconscious.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */