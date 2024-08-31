/*    */ package Koishi.cards.Powers.Uncommon;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.UntouchablePower;
/*    */ import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class Untouchable extends AbstractDefaultCard {
/* 18 */   public static final String ID = KoishiMod.makeID(Untouchable.class.getSimpleName());
/* 19 */   public static final String IMG = KoishiMod.makeCardPath("Untouchable.png");
/*    */   
/* 21 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 22 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 23 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.POWER;
/* 24 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   private static final int BUFF = 6;
/*    */   
/*    */   public Untouchable() {
/* 30 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 31 */     this.magicNumber = this.baseMagicNumber = 6;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 36 */     KoishiMod.runAnimation("spellC");
/* 37 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new AddTemporaryHPAction((AbstractCreature)AbstractDungeon.player, (AbstractCreature)AbstractDungeon.player, this.magicNumber));
/* 38 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new UntouchablePower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 43 */     if (!this.upgraded) {
/* 44 */       upgradeName();
/* 45 */       this.isInnate = true;
/* 46 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 47 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Powers/Uncommon/Untouchable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */