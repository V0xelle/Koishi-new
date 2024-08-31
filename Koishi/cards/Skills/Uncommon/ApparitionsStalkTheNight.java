/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.LoseHPAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
/*    */ 
/*    */ public class ApparitionsStalkTheNight extends AbstractDefaultCard {
/* 19 */   public static final String ID = KoishiMod.makeID(ApparitionsStalkTheNight.class.getSimpleName());
/* 20 */   public static final String IMG = KoishiMod.makeCardPath("ApparitionsStalkTheNight.png");
/*    */   
/* 22 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 23 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 24 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 25 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int BUFF = 1;
/*    */   
/*    */   private static final int HP_LOSS = 5;
/*    */   
/*    */   public ApparitionsStalkTheNight() {
/* 34 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 35 */     this.magicNumber = this.baseMagicNumber = 1;
/* 36 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 5;
/* 37 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 42 */     KoishiMod.runAnimation("spellB");
/* 43 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new LoseHPAction((AbstractCreature)p, (AbstractCreature)p, this.defaultSecondMagicNumber));
/* 44 */     if (!p.hasPower("IntangiblePlayer") && !p.hasPower("Intangible")) {
/* 45 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new IntangiblePlayerPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 52 */     return 12.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 58 */     if (!this.upgraded) {
/* 59 */       upgradeName();
/* 60 */       this.isInnate = true;
/* 61 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 62 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/ApparitionsStalkTheNight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */