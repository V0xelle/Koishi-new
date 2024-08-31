/*    */ package Koishi.cards.Skills.Rare;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.TerrorPower;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class ImGoingToCallYouNow extends AbstractDefaultCard {
/* 19 */   public static final String ID = KoishiMod.makeID(ImGoingToCallYouNow.class.getSimpleName());
/* 20 */   public static final String IMG = KoishiMod.makeCardPath("ImGoingToCallYouNow.png");
/*    */   
/* 22 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 23 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 24 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 25 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DEBUFF = 3;
/*    */   private static final int UPGRADE_PLUS_DEBUFF = 2;
/*    */   
/*    */   public ImGoingToCallYouNow() {
/* 33 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 34 */     this.magicNumber = this.baseMagicNumber = 3;
/* 35 */     this.exhaust = true;
/* 36 */     KoishiMod.setBackground((CustomCard)this, 1);
/* 37 */     this.cardsToPreview = (AbstractCard)new SoAnswerThePhone();
/* 38 */     this.tags.add(AbstractCard.CardTags.HEALING);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 43 */     KoishiMod.runAnimation("lastWord");
/* 44 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new TerrorPower((AbstractCreature)m, (AbstractCreature)p, this.magicNumber), this.magicNumber));
/* 45 */     SoAnswerThePhone soAnswerThePhone = new SoAnswerThePhone();
/* 46 */     if (this.upgraded) {
/* 47 */       soAnswerThePhone.upgrade();
/*    */     }
/* 49 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)soAnswerThePhone, true));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 55 */     return 12.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 61 */     if (!this.upgraded) {
/* 62 */       upgradeName();
/* 63 */       upgradeMagicNumber(2);
/* 64 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 65 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Rare/ImGoingToCallYouNow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */