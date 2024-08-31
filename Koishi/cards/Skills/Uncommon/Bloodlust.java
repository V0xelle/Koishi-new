/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.BloodlustPower;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class Bloodlust extends AbstractDefaultCard {
/* 19 */   public static final String ID = KoishiMod.makeID(Bloodlust.class.getSimpleName());
/* 20 */   public static final String IMG = KoishiMod.makeCardPath("Bloodlust.png");
/*    */   
/* 22 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 23 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 24 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 25 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int ENERGY = 2;
/*    */   private static final int UPGRADE_ENERGY = 1;
/*    */   
/*    */   public Bloodlust() {
/* 33 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 34 */     this.magicNumber = this.baseMagicNumber = 2;
/* 35 */     this.exhaust = true;
/* 36 */     AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 41 */     KoishiMod.runAnimation("spellC");
/* 42 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainEnergyAction(this.magicNumber));
/* 43 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new BloodlustPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 49 */     if (!this.upgraded) {
/* 50 */       upgradeName();
/* 51 */       upgradeMagicNumber(1);
/* 52 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 53 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/Bloodlust.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */