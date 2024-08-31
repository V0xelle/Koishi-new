/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.EphemeralPower;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.LoseHPAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class Vanish extends AbstractDefaultCard {
/* 17 */   public static final String ID = KoishiMod.makeID(Vanish.class.getSimpleName());
/* 18 */   public static final String IMG = KoishiMod.makeCardPath("Vanish.png");
/*    */   
/* 20 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 21 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 22 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 23 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int BUFF = 7;
/*    */   
/*    */   private static final int UPGRADE_PLUS_BUFF = 2;
/*    */   private static final int HP_LOSS = 3;
/*    */   
/*    */   public Vanish() {
/* 33 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 34 */     this.magicNumber = this.baseMagicNumber = 7;
/* 35 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 3;
/* 36 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 41 */     KoishiMod.runAnimation("spellB");
/* 42 */     for (int i = 0; i < this.defaultSecondMagicNumber; i++) {
/* 43 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new LoseHPAction((AbstractCreature)p, (AbstractCreature)p, 1));
/*    */     }
/* 45 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EphemeralPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 50 */     if (!this.upgraded) {
/* 51 */       upgradeName();
/* 52 */       upgradeMagicNumber(2);
/* 53 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/Vanish.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */