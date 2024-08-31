/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.FourthEyeAction;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class FourthEye
/*    */   extends AbstractDefaultCard {
/* 16 */   public static final String ID = KoishiMod.makeID(FourthEye.class.getSimpleName());
/* 17 */   public static final String IMG = KoishiMod.makeCardPath("FourthEye.png");
/*    */   
/* 19 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 20 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 21 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 22 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   public FourthEye() {
/* 27 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 28 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 33 */     KoishiMod.runAnimation("spellCall");
/* 34 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new FourthEyeAction());
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 39 */     if (!this.upgraded) {
/* 40 */       upgradeName();
/* 41 */       this.isInnate = true;
/* 42 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 43 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/FourthEye.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */