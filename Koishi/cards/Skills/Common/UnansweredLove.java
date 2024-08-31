/*    */ package Koishi.cards.Skills.Common;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.EphemeralPower;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
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
/*    */ 
/*    */ public class UnansweredLove extends AbstractDefaultCard {
/* 19 */   public static final String ID = KoishiMod.makeID(UnansweredLove.class.getSimpleName());
/* 20 */   public static final String IMG = KoishiMod.makeCardPath("UnansweredLove.png");
/*    */   
/* 22 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 23 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 24 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 25 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int BUFF = 2;
/*    */   
/*    */   private static final int HP_LOSS = 1;
/*    */   
/*    */   public UnansweredLove() {
/* 34 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 35 */     this.magicNumber = this.baseMagicNumber = 2;
/* 36 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 41 */     KoishiMod.runAnimation("spellB");
/* 42 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new LoseHPAction((AbstractCreature)p, (AbstractCreature)p, this.defaultSecondMagicNumber));
/* 43 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EphemeralPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 48 */     if (!this.upgraded) {
/* 49 */       upgradeName();
/* 50 */       AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/* 51 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 52 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Common/UnansweredLove.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */